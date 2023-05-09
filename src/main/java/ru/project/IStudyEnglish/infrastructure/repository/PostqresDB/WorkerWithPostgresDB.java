package ru.project.IStudyEnglish.infrastructure.repository.PostqresDB;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;

public interface WorkerWithPostgresDB {

    @Autowired
    ConnectDB conDB = new ConnectDB();

    public default void create(String sqlString){
        conDB.update(sqlString);
    }
    public default ResultSet read(String sqlString){
        return conDB.getResultSet(sqlString);
    }
    public default void update(String sqlString){
        conDB.update(sqlString);
    }
    public default void delete(String sqlString){
        conDB.update(sqlString);
    }
    private void fillFromData(String sql) {}
}
