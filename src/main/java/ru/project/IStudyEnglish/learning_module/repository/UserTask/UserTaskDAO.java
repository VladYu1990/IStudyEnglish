package ru.project.IStudyEnglish.learning_module.repository.UserTask;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.user_module.entity.User.User;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;

import java.util.List;

@Log4j2
@Component
public class UserTaskDAO implements SourceUserTask {

    private JdbcTemplate jdbcTemplate;
    private UserTaskMapper userTaskMapper;

    public UserTaskDAO() {
    }

    @Autowired
    public UserTaskDAO(JdbcTemplate jdbcTemplate, UserTaskMapper userTaskMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userTaskMapper = userTaskMapper;
    }

    public UserTask getOnId(int id) {
        String sql = "SELECT * FROM user_tasks WHERE id = (?) limit 1";
        //TODO повторяется
        return jdbcTemplate.query(sql, new Object[]{id}, userTaskMapper)
                .stream().findAny().orElse(null);
    }

    @Override
    public void save(UserTask userTask) {
        String strSQL = createStrSQLForSave(userTask);

        jdbcTemplate.update(strSQL);
    }

    @Override
    public void save(List<UserTask> list) {
        String strSQL = "";
        for(int i =0;i<list.size();i++){
            strSQL = strSQL + createStrSQLForSave(list.get(i));
        }

        try {
            jdbcTemplate.update(strSQL);
        }
        catch (Exception e){

        };
    }

    private String createStrSQLForSave(UserTask userTask){
            String sql = "\n insert into user_tasks (" +
                    "id," +
                    "user_code," +
                    "id_task," +
                    "status," +
                    "time_last_repetition," +
                    "time_next_repetition," +
                    "correct_attempts_counter)" +
                    "values (" +
                    "nextval('id_user_tasks')" + "," +
                    "" + userTask.getUser().getId() + "," +
                    "" + userTask.getTask().getId() + "," +
                    "'" + userTask.getStatus() + "'," +
                    "'" + userTask.getTimeLastRepetition() + "'," +
                    "'" + userTask.getTimeNextRepetition() + "'," +
                    "" + userTask.getCorrectAttemptsCounter() + ");";

            return sql;
    }


    public int getNext(User user) {
        String sql = "SELECT * " +
                "from user_tasks " +
                "where user_code in (?)" +
                //TODO fix status code
                "and status <> ('3')" + //это статус заданий для изучения/повторения, остальные или рано или уже выучили
                "and time_next_repetition <= clock_timestamp()" + //наступившее
                "order by time_next_repetition desc " + // но самое новое,
                // иначе если пользователь будет редко заходить,
                // он будет повторять только старые слова не доходя до недавних и тем самым,
                // будут большие перерывы в повторении
                //лучше выучить 1 слово хорошо, чем 100 - ни как
                "limit 1";
        UserTask userTask = jdbcTemplate.query(sql, new Object[]{user.getId()}, userTaskMapper)
                .stream().findAny().orElse(null);

        return userTask.getId();
    }

    public void update(UserTask userTask){
        String sql = "update user_tasks u " +
                "set " +
                    "status = ('" + userTask.getStatus() +
                    "'), correct_attempts_counter = ('" + userTask.getCorrectAttemptsCounter()  +
                    "'), time_last_repetition = ('" + userTask.getTimeLastRepetition() +
                    "'), time_next_repetition = ('" + userTask.getTimeNextRepetition() +
                "') where id = " + userTask.getId();

        jdbcTemplate.update(sql);

    }

    public void truncate() {

        String sql = "TRUNCATE user_tasks";
        try {
            jdbcTemplate.update(sql);
        }
        catch (Exception e){}
    }
}
