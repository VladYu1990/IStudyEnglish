package ru.project.IStudyEnglish.learning_module.repository.Task;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
<<<<<<< HEAD
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.learning_module.entity.Task.TranslationDirection;
import ru.project.IStudyEnglish.learning_module.entity.Task.TypeTask;
=======
import ru.project.IStudyEnglish.learning_module.entity.Task.TypeTask;
import ru.project.IStudyEnglish.learning_module.service.DirectorBuilderQuestion;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.learning_module.entity.Task.TranslationDirection;
>>>>>>> origin/main

import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
@Component
public class TaskMapper implements RowMapper<Task> {

<<<<<<< HEAD


    @Autowired
    public TaskMapper() {
=======
    private Task task = new Task();
    private DirectorBuilderQuestion directorBuilderQuestion;

    @Autowired
    public TaskMapper(DirectorBuilderQuestion directorBuilderQuestion) {
        this.directorBuilderQuestion = directorBuilderQuestion;
>>>>>>> origin/main
    }

    @Override
    public Task mapRow(ResultSet resultSet, int rowNum) throws SQLException {
<<<<<<< HEAD
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
=======

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
>>>>>>> origin/main
    }
}