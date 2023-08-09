package ru.project.IStudyEnglish.learning_module.repository.User;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.User.User;

@Log4j2
@Component
public class UserDAO implements SourceUser {

    private JdbcTemplate jdbcTemplate;
    private UserMapper userMapper;

    public UserDAO() {
    }

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate,UserMapper userMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = userMapper;
    }

    public User getUser(int id){
        String sql = "SELECT * FROM users where id = (?) limit 1";
        return jdbcTemplate.query(sql, new Object[]{id}, userMapper)
                .stream().findAny().orElse(null);
    }

    public User getUser(String login,String password){
        String sql = "SELECT * FROM users where login in '(?)' and password in '(?)' limit 1";
        return jdbcTemplate.query(sql, new Object[]{login,password}, userMapper)
                .stream().findAny().orElse(null);

    }

    public User getUser(String login){
        String sql = "SELECT * FROM users where login in '(?)' limit 1";
        return jdbcTemplate.query(sql, new Object[]{login}, userMapper)
                .stream().findAny().orElse(null);

    }

    public User getOnToken(String tokenStr){
        String sql = "SELECT * FROM users where token in '(?)' limit 1";
        return jdbcTemplate.query(sql, new Object[]{tokenStr}, userMapper)
                .stream().findAny().orElse(null);
    }

    public void save(User user){
        String strSQL =
                "insert into users values( " +
                        "nextval('id_users'), " +
                        "'" + user.getLogin() + "', " +
                        "'" + user.getPassword() + "');";

        jdbcTemplate.update(strSQL);
    }
}

