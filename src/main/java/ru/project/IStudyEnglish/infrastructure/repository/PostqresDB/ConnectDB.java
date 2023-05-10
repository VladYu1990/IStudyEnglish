package ru.project.IStudyEnglish.infrastructure.repository.PostqresDB;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.project.IStudyEnglish.infrastructure.repository.StringSQL;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
@Repository
@Scope("prototype")
public class ConnectDB {

    private Statement statement;

    @Autowired
    public ConnectDB(ConConfig conConfig) {

        try {
            this.statement = DriverManager.getConnection(
                            conConfig.getDB_url(),
                            conConfig.getUser(),
                            conConfig.getPassword())
                    .createStatement();

        } catch (SQLException sqlException) {
            log.error(sqlException);
        }
        log.info("conDB created");
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

    public void update(StringSQL sqlString) {
        String sql = sqlString.getStringSQL();
        try {
            this.statement.executeUpdate(sql);
        } catch (SQLException sqlException) {
            log.error(sqlException);
        }
    }
}


