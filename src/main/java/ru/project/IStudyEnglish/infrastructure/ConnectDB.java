package ru.project.IStudyEnglish.infrastructure;

import java.sql.*;

public class ConnectDB {
    private String DB_url = "jdbc:postgresql://localhost:5432/IStudyEnglishDemo";
    private String user = "postgres";
    private String password ="5240";
    private String Sql = "select * from test";

    public void connectionDB() throws SQLException {
        Connection connectionDB = DriverManager.getConnection(DB_url,user,password);

        Statement statement = connectionDB.createStatement();
        ResultSet result = statement.executeQuery(Sql);//запрос, в ответ результат
        //int result2 = statement.executeUpdate(Sql);// апдейте, делет и инсерт, в ответ инт-кол-ва строк

        while (result.next()){
            System.out.println(result.getInt("id"));
        }

    }

}
