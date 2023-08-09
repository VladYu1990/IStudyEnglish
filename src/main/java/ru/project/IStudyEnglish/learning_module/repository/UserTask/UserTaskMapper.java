package ru.project.IStudyEnglish.learning_module.repository.UserTask;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.service.DirectorBuilderTask;
import ru.project.IStudyEnglish.learning_module.service.DirectorBuilderUser;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTaskStatusEnum;

import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
@Component
public class UserTaskMapper implements RowMapper<UserTask> {

    private UserTask userTask = new UserTask();
    private DirectorBuilderUser directorBuilderUser;
    private DirectorBuilderTask directorBuilderTask;

    public UserTaskMapper() {
    }

    @Autowired
    public UserTaskMapper(DirectorBuilderUser directorBuilderUser, DirectorBuilderTask directorBuilderTask) {
        this.directorBuilderUser = directorBuilderUser;
        this.directorBuilderTask = directorBuilderTask;
    }

    @Override
    public UserTask mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        userTask.setId(resultSet.getInt("id"));
        userTask.setUser(
                directorBuilderUser.getOnId(
                        resultSet.getInt("user_code")));
        userTask.setTask(
                directorBuilderTask.getOnId(
                        resultSet.getInt("id_task")));
        userTask.setStatus(UserTaskStatusEnum.cast(
                resultSet.getInt("status")));
        userTask.setCorrectAttemptsCounter(resultSet.getInt("correct_attempts_counter"));
        userTask.setTimeLastRepetition(resultSet.getTimestamp("time_last_repetition"));
        userTask.setTimeNextRepetition(resultSet.getTimestamp("time_next_repetition"));

        return userTask;
    }
}