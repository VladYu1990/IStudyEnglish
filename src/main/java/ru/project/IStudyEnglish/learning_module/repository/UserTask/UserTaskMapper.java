package ru.project.IStudyEnglish.learning_module.repository.UserTask;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTaskStatusEnum;
import ru.project.IStudyEnglish.learning_module.service.Task.BuilderTask;
import ru.project.IStudyEnglish.user_module.service.User.BuilderUser;

import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
@Component
public class UserTaskMapper implements RowMapper<UserTask> {

    private UserTask userTask = new UserTask();
    BuilderUser builderUser;
    BuilderTask builderTask;

    @Autowired
    public UserTaskMapper(BuilderUser builderUser, BuilderTask builderTask) {
        this.builderUser = builderUser;
        this.builderTask = builderTask;
    }


    @Override
    public UserTask mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        userTask.setId(resultSet.getInt("id"));
        userTask.setUser(
                        builderUser.getUser(resultSet.getInt("user_code")));
        userTask.setTask(
                        builderTask.get(resultSet.getInt("id_task")));
        userTask.setStatus(UserTaskStatusEnum.valueOf(
                resultSet.getString("status")));
        userTask.setCorrectAttemptsCounter(resultSet.getInt("correct_attempts_counter"));
        userTask.setTimeLastRepetition(resultSet.getTimestamp("time_last_repetition"));
        userTask.setTimeNextRepetition(resultSet.getTimestamp("time_next_repetition"));

        return userTask;
    }
}