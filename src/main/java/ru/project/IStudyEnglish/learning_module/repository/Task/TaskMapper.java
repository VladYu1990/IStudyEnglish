package ru.project.IStudyEnglish.learning_module.repository.Task;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Task.TypeTask;
import ru.project.IStudyEnglish.learning_module.service.DirectorBuilderQuestion;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.learning_module.entity.Task.TranslationDirection;

import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
@Component
public class TaskMapper implements RowMapper<Task> {

    private Task task = new Task();
    private DirectorBuilderQuestion directorBuilderQuestion;

    @Autowired
    public TaskMapper(DirectorBuilderQuestion directorBuilderQuestion) {
        this.directorBuilderQuestion = directorBuilderQuestion;
    }

    @Override
    public Task mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        this.task.setId(resultSet.getInt("id"));
        this.task.setTypeTask(
                TypeTask.valueOf(
                        resultSet.getString("questions")));
        this.task.setTranslationDirection((
                TranslationDirection.valueOf(
                        resultSet.getString("translation_direction"))));

        this.task.setCreated(resultSet.getTimestamp("created"));
        this.task.setUpdated(resultSet.getTimestamp("updated"));

        return this.task;
    }
}