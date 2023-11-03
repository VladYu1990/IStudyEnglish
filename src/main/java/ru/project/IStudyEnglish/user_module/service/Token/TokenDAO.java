package ru.project.IStudyEnglish.user_module.service.Token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.user_module.entity.User.Token;

import java.util.ArrayList;
import java.util.List;

@Component
public class TokenDAO {

    private JdbcTemplate jdbcTemplate;
    private TokenMapper tokenMapper;

    @Autowired
    public TokenDAO(JdbcTemplate jdbcTemplate, TokenMapper tokenMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.tokenMapper = tokenMapper;
    }

    public Token getToken(int id){
        String sql =
                "SELECT * " +
                        "FROM  user_token" +
                        "where id_user = (?) ";
        return jdbcTemplate.query(sql, new Object[]{id}, tokenMapper)
                .stream().findAny().orElse(null);
    }

    public Token getToken(String tokenStr){
        String sql =
                "SELECT * " +
                        "FROM  user_token " +
                        "where tokenstr in (?) ";
        return jdbcTemplate.query(sql, new Object[]{tokenStr}, tokenMapper).get(0);
    }

    public List<Token> getToken(ArrayList<String> tokenStr){
        String s = tokenStr.toString().
                replace("[","'").
                replace("]","'");

        String sql =
                "SELECT * " +
                        "FROM  user_token " +
                        "where tokenstr in (?) ";
        return jdbcTemplate.query(sql, new Object[]{s}, tokenMapper);
    }

    public void save(Token token){
        jdbs(createSql(token));
    }

    public void save(List<Token> tokenList) {
        String sql = "";
        for (int i = 0; tokenList.size() < i; i++) {
            sql = sql + createSql(tokenList.get(i));
        }
        jdbs(sql);
    }

    private String createSql(Token token){
        return "insert into user_token (id_user, tokenstr,  token_date_created, token_date_die) " +
                "values ('" + token.getIdUser() + "','"
                + token.getTokenStr() + "','"
                + token.getDateCreated() +"','"
                + token.getDateDie() + "');";
    }

    private void jdbs(String sql){
        jdbcTemplate.update(sql);
    }

}
