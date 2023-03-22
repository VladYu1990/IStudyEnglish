package ru.project.IStudyEnglish.infrastructure;

import java.sql.*;

public class ConnectDB {
    private String DB_url = "jdbc:postgresql://localhost:5432/IStudyEnglishDemo";
    private String user = "postgres";
    private String password ="5240";

    private String SqlOneWord = "select * from test";

    public ConnectDB() {
    }


    public void connectionDB() throws SQLException {
        String sql = SqlOneWord;
        Connection connectionDB = DriverManager.getConnection(DB_url,user,password);

        Statement statement = connectionDB.createStatement();
        ResultSet result = statement.executeQuery(sql);//запрос, в ответ результат
        //int result2 = statement.executeUpdate(Sql);// апдейте, делет и инсерт, в ответ инт-кол-ва строк
        int id = 3;
        while (result.next()){
            System.out.println(result.getInt("id"));
            System.out.println(result.getString(2));
        }

    }
    public Statement getStatement() throws SQLException {
        ConnectDB conDB = new ConnectDB();
        Connection connectionDB = DriverManager.getConnection(conDB.DB_url,conDB.user,conDB.password);

        Statement statement = connectionDB.createStatement();
        return statement;
    }


}
