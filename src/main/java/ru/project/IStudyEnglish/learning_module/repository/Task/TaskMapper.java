package ru.project.IStudyEnglish.learning_module.repository.Task;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.learning_module.entity.Task.TranslationDirection;
import ru.project.IStudyEnglish.learning_module.entity.Task.TypeTask;

import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
@Component
public class TaskMapper implements RowMapper<Task> {



    @Autowired
    public TaskMapper() {
    }

    @Override
    public Task mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getInt("id"));
        task.setTypeTask(
                TypeTask.valueOf(
                        resultSet.getString("type_task")));
        task.setQuestion(resultSet.getString("question"));
        task.setTrueAnswer(resultSet.getInt("true_answer"));
        task.setTranslationDirection((
                TranslationDirection.valueOf(
                        resultSet.getString("translation_direction"))));

        task.setCreated(resultSet.getTimestamp("created"));
        task.setUpdated(resultSet.getTimestamp("updated"));

        return task;
    }
}