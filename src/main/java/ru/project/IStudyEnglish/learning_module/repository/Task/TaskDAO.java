package ru.project.IStudyEnglish.learning_module.repository.Task;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;

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

    public Task getOnId(int id_int){

        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(id_int);
        return getOnId(integerList).get(0);
    }

    public List<Task> getOnId(List<Integer> integerList)  {

        String sql = "SELECT * FROM tasks where id = (?)";
        return jdbcTemplate.query(sql, new Object[]{integerList}, taskMapper);
    }

    @Override
    public void create(Task task) {
        List<Task> taskList = new ArrayList<Task>();
        taskList.add(task);
        create(taskList);

    }

    @Override
    public void create(List<Task> list) {
        String sql = "";

        for (int i=0;i<list.size();i++){
            sql = sql + createSQL(list.get(i));
        }
        jdbcTemplate.update(sql);
    }

    private String createSQL(Task task){
        String sql = "";

        sql = "insert into tasks (\n" +
                    "id int primary key,\n" +
                    "type_task text,\n" +
                    "question text,\n" +
                    "translation_direction text,\n" +
                    "created timestamp,\n" +
                    "updated timestamp,\n" +
                    "id_source int,\n" +
                    "type_source text) " +
                "values (nextval('id_tasks')," +
                    "" + task.getTypeTask().toString() + "','" +
                    "" + task.getQuestion() + "','" +
                    "" + task.getTranslationDirection().toString() + "'," +
                    "" + task.getCreated() + "," +
                    "" + task.getUpdated() + "," +
                    "" + task.getIdSource() + ",'" +
                    "" + task.getTypeSource().toString() + "');";

        return sql;
    }

    @Override
    public void update(List<Task> list) {

    }

    @Override
    public void update(Task task) {

    }

}

