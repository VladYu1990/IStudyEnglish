package ru.project.IStudyEnglish.infrastructure.repository.PostqresDB;

import ru.project.IStudyEnglish.infrastructure.repository.StringSQL;

import java.sql.ResultSet;

public interface WorkerWithPostgresDB {


    public default void create(StringSQL sqlString, ConnectDB conDB){
        conDB.update(sqlString);
    }
    public default ResultSet read(StringSQL sqlString, ConnectDB conDB){
        return conDB.getResultSet(sqlString.getStringSQL());
    }
    public default void update(StringSQL sqlString, ConnectDB conDB){
        conDB.update(sqlString);
    }
    public default void delete(StringSQL sqlString, ConnectDB conDB){

        conDB.update(sqlString);
    }
    private void fillFromData(String sql) {}

    }

