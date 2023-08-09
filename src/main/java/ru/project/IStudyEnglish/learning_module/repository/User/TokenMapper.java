package ru.project.IStudyEnglish.learning_module.repository.User;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.user_module.entity.User.Token;

import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
@Component
public class TokenMapper  implements RowMapper<Token> {



    @Autowired
    public TokenMapper() {
    }


    @Override
    public Token mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Token token = new Token();
        token.setIdUser(resultSet.getInt("id_user"));
        token.setTokenStr(resultSet.getString("tokenstr"));
        token.setDateCreated(resultSet.getTimestamp("token_date_created"));
        token.setDateDie(resultSet.getTimestamp("token_date_die"));

        return token;
    }
}
