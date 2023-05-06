package ru.project.IStudyEnglish.infrastructure.repository.PostqresDB;

import lombok.extern.log4j.Log4j2;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class ConnectDB {
    private final String DB_url = "jdbc:postgresql://localhost:5432/IStudyEnglishDemo";
    private final String user = "postgres";
    private final String password = "5240";
    private Statement statement;

    public ConnectDB() {
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


