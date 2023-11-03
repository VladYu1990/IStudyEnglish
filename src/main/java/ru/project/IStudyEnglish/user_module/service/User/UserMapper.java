package ru.project.IStudyEnglish.user_module.service.User;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.user_module.entity.User.User;

import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
@Component
public class UserMapper  implements RowMapper<User> {

    private User user = new User();

    @Autowired
    public UserMapper(){
    }

    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        this.user.setId(resultSet.getInt("id"));
        this.user.setLogin(resultSet.getString("login"));
        this.user.setPassword(resultSet.getString("password"));

        return this.user;
    }
}
