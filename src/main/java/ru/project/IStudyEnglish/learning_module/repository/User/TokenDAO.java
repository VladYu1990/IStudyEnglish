package ru.project.IStudyEnglish.learning_module.repository.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.User.Token;

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
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add(tokenStr);
        return getToken(stringArrayList).get(0);
    }

    public List<Token> getToken(ArrayList<String> tokenStr){
        String sql =
                "SELECT * " +
                        "FROM  user_token" +
                        "where tokenstr = (?) ";
        return jdbcTemplate.query(sql, new Object[]{tokenStr}, tokenMapper);
    }

    public void save(Token token){
        List<Token> tokenList = new ArrayList<>();
        tokenList.add(token);
        save(tokenList);
    }

    public void save(List<Token> tokenList) {
        String sql = "";
        for (int i = 0; tokenList.size() < i; i++) {
            sql = sql + "insert into user_token (id_user, tokenstr,  token_date_created, token_date_die) " +
                    "values ('" + tokenList.get(i).getIdUser() + "','"
                    + tokenList.get(i).getTokenStr() + "','"
                    + tokenList.get(i).getDateCreated() +"','"
                    + tokenList.get(i).getDateDie() + "');";
        }
    }
}
