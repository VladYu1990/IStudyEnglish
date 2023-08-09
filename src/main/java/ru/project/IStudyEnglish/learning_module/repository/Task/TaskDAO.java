package ru.project.IStudyEnglish.learning_module.repository.Task;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.learning_module.entity.TypeSource;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
public class TaskDAO implements SourceTask {
    private JdbcTemplate jdbcTemplate;

    private TaskMapper taskMapper;
    public TaskDAO(){
    }

    @Autowired
    public TaskDAO(JdbcTemplate jdbcTemplate, TaskMapper taskMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.taskMapper = taskMapper;
    }

    public Task get(int id){

        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(id);
        return get(integerList).get(0);
    }

    public List<Task> get(List<Integer> integerList)  {
        String str = integerList.get(0).toString();
        for (int i=1;i<integerList.size();i++){
             str = str + "," + integerList.get(i);
        }
        String sql = "SELECT * FROM tasks where id = (" + str + ");";
        return jdbcTemplate.query(sql,taskMapper);
    }

    public List<Task> get(TypeSource sourceType, int id){
        String strSourceType = sourceType.toString();
        String sql =
                "SELECT * " +
                "FROM tasks " +
                "where id_source = (?)" +
                        "and type_source in (?)";

        return jdbcTemplate.query(sql, new Object[]{id,strSourceType}, taskMapper);

    }

    @Override
    public void save(Task task) {
        jdbcUpdate(createSQL(task));
    }

    @Override
    public void save(List<Task> list) {
        int count = 0;
        for (int i=0;i<list.size();i++){
            count = count + jdbcUpdate(createSQL(list.get(i)));
        }
        log.info("запрос на создание " + list.size() + " Tasks выполнен");
        log.info("создано " + count + " новых Tasks");
    }

    private String createSQL(Task task){
        String sql = "";

        sql = "insert into tasks (" +
                    "id," +
                    "type_task," +
                    "question," +
                    "true_answer," +
                    "translation_direction," +
                    "created," +
                    "updated," +
                    "id_source," +
                    "type_source) " +
                "values (nextval('id_tasks')," +
                    "'" + task.getTypeTask().toString() + "'," +
                    "'" + task.getQuestion() + "'," +
                    "'" + task.getTrueAnswer() + "'," +
                    "'" + task.getTranslationDirection().toString() + "'," +
                    "'" + task.getCreated() + "'," +
                    "'" + task.getUpdated() + "'," +
                    "" + task.getSource().getId() + "," +
                    "'" + task.getSource().getTypeSource().toString() + "');\n";
        return sql;
    }

    private int jdbcUpdate(String sql){
        try {
            return jdbcTemplate.update(sql);
        }
        catch (Exception e){
            return 0;
        }

    }

    @Override
    public void update(List<Task> list) {

    }

    @Override
    public void update(Task task) {

    }

}

