package ru.project.IStudyEnglish.infrastructure.repository.PostqresDB;

import java.sql.ResultSet;

public interface WorkerWithPostgresDB {

    
    ConnectDB conDB=null;

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

