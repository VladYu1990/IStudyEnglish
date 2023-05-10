package ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.DAO;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.domen.DTO.Task.TypeTask;
import ru.project.IStudyEnglish.infrastructure.SourceUserTask;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.ConnectDB;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.WorkerWithPostgresDB;

import java.sql.ResultSet;
import java.sql.Timestamp;

@Log4j2
@Component
public class UserTaskDAO implements SourceUserTask, WorkerWithPostgresDB {
    private int id;
    private int userCode;
    private int idTask;
    private TypeTask typeTask;
    private int status;
    private Timestamp timeLastRepetition;
    private Timestamp timeNextRepetition;
    private int correctAttemptsCounter;
    private ConnectDB conDB;

    public UserTaskDAO(){
    }

    //@Autowired
    public UserTaskDAO(ConnectDB conDB){
        this.conDB = conDB;
    }


    public void getOnId(int id){
        String sql = "select * from user_task where id in ('"+ String.valueOf(id) + "') limit 1";
        fill(sql);
    }

    public void getNext(String userCode){
        String sql = "select * " +
                "from user_task " +
                "where user_code in ('"+ userCode + "')  " +
                "and status <> ('3')" + //это статус заданий для изучения/повторения, остальные или рано или уже выучили
                "and time_next_repetition <= clock_timestamp()" + //наступившее
                "order by time_next_repetition desc " + // но самое новое,
                // иначе если пользователь будет редко заходить,
                // он будет повторять только старые слова не доходя до недавних и тем самым,
                // будут большие перерерывы в повторении
                //лучше выучить 1 слово хорошо, чем 100 - ни как
                "limit 1";
        fill(sql);
    }

    private void fill(String sql){
        ResultSet data = read(sql);
        try {
            while (data.next()) {
                //TODO изменить типы данных в БД
                this.id = Integer.parseInt(data.getString("id"));
                this.userCode = Integer.parseInt(data.getString("user_code"));
                this.idTask = Integer.parseInt(data.getString("id_task"));
                this.typeTask = TypeTask.valueOf(data.getString("type_task"));
                this.status = Integer.valueOf(data.getString("status"));
                this.timeLastRepetition = data.getTimestamp("time_last_repetition");
                this.timeNextRepetition = data.getTimestamp("time_next_repetition");
                this.correctAttemptsCounter = Integer.parseInt(data.getString("correct_attempts_counter"));

            }
        } catch (Exception ex) {
            log.error(ex);
        }
    }

    public void update(){
        String sqlUpdate = "UPDATE user_task " +
                "SET status = '" + this.status + "' " +
                ",time_last_repetition = '" + this.timeLastRepetition + "' " +
                ",time_next_repetition  = '" + this.timeNextRepetition + "' " +
                ",correct_attempts_counter = '" + this.correctAttemptsCounter + "' " +
                "WHERE id = '" + this.id + "';";
        update(sqlUpdate);
    }

    public void create(String sqlString) {
        WorkerWithPostgresDB.super.create(sqlString);
    }

    public int getId() {
        return id;
    }

    public int getUserCode() {
        return userCode;
    }

    public int getIdTask() {
        return idTask;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public int getStatus() {
        return status;
    }

    public Timestamp getTimeLastRepetition() {
        return timeLastRepetition;
    }

    public Timestamp getTimeNextRepetition() {
        return timeNextRepetition;
    }

    public int getCorrectAttemptsCounter() {
        return correctAttemptsCounter;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimeLastRepetition(Timestamp timeLastRepetition) {
        this.timeLastRepetition = timeLastRepetition;
    }

    public void setTimeNextRepetition(Timestamp timeNextRepetition) {
        this.timeNextRepetition = timeNextRepetition;
    }

    public void setCorrectAttemptsCounter(int correctAttemptsCounter) {
        this.correctAttemptsCounter = correctAttemptsCounter;
    }
}
