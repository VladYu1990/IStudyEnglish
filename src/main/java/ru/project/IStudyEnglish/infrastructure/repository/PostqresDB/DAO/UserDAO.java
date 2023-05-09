package ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.DAO;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.infrastructure.SourceUser;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.WorkerWithPostgresDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Log4j2
public class UserDAO implements SourceUser, WorkerWithPostgresDB {
    private int id;
    private String token;
    private Timestamp timeLifeToken;
    private String login;
    private String password;
    private Timestamp blockedBeforeToThisTime;

    private ResultSet resultSet;

    public UserDAO() {

    }

    public void fillViaId(String id){
        String sqlString = "select * from users where id = " + id + "limit 1";
        parsingDateFromDB(sqlString);
    }

    public void fillViaToken(String token){
        String sqlString = "select * from users where token = " + token + "limit 1";
        parsingDateFromDB(sqlString);
    }

    public void fillViaLogin(String login){
        String sqlString = "select * from users where login = " + login + "limit 1";
        parsingDateFromDB(sqlString);
    }

    private void parsingDateFromDB(String sql) {
        try {
            resultSet = read(sql);

            while (resultSet.next()) {
                this.id = Integer.valueOf(resultSet.getString("id"));
                this.token = resultSet.getString("token");
                this.timeLifeToken = resultSet.getTimestamp("time_life_toke");
                this.login = resultSet.getString("login");
                this.password = resultSet.getString("password");
                this.blockedBeforeToThisTime = resultSet.getTimestamp("blocked_before_to_this_time");

            }
        }
        catch (SQLException sqlException) {
            log.error(sqlException);
        }
    }

    public String getNewToken(String login, String password) {
        //TODO реализовать проверку в бд и генерацию нового токена

        this.timeLifeToken = new Timestamp(System.currentTimeMillis()+30);
        //TODO  сделать апдейт токена и времени его жизни
        //conDB.update();


        return this.token;

    }
}
