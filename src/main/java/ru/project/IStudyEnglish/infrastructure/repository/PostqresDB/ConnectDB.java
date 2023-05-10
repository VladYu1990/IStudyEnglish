package ru.project.IStudyEnglish.infrastructure.repository.PostqresDB;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
//@Repository
public class ConnectDB {
    @Value("${spring.datasource.url}")
    private String DB_url;
    @Value("postgres")
    private String user;
    //@Value("${spring.datasource.password}")
    private String password="5240";
    @Value("${test.test}")
    private String str1;
    @Value("${test.test}")
    public String str2;
    private Statement statement;

    public ConnectDB() {
        log.info(DB_url);
        log.info(user);
        log.info(password);
        log.info(str1);
        log.info(str2);
        try {
            this.statement = DriverManager.getConnection(
                            this.DB_url,
                            this.user,
                            this.password)
                    .createStatement();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        }
    }


    public Statement getStatement() {
        return this.statement;
    }

    public ResultSet getResultSet(String strSQL) {
        try {
            return this.statement.executeQuery(strSQL);
        } catch (SQLException sqlException) {
            log.error(sqlException);

            //TODO возвращать нул плохо, нужно переделать
            return null;
        }
    }

    public void update(String sqlUpdate) {
        try {
            this.statement.executeUpdate(sqlUpdate);
        } catch (SQLException sqlException) {
            log.error(sqlException);
        }
    }
}


