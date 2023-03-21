package ru.project.IStudyEnglish.infrastructure;

import ru.project.IStudyEnglish.DTO.Word;

import java.sql.*;

public class ConnectDB {
    private String DB_url = "jdbc:postgresql://localhost:5432/IStudyEnglishDemo";
    private String user = "postgres";
    private String password ="5240";

    private String SqlOneWord = "select * from test";

    public ConnectDB() {
    }

    public ConnectDB(int i) throws SQLException {
        Connection connectionDB = DriverManager.getConnection(DB_url,user,password);
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
    public Word getNextRepetitionExercise()  throws SQLException{
        String sql = "Select * from TaskForRepetition order by timeNextRepetition limit 1";
        Connection connectionDB = DriverManager.getConnection(DB_url,user,password);

        Statement statement = connectionDB.createStatement();
        ResultSet result = statement.executeQuery(sql);//запрос, в ответ результат

        int number_word = 1; //result.getInt("id_word");

        sql = "Select * from words where id=2";//"+String.valueOf(number_word);

        result = statement.executeQuery(sql);//запрос, в ответ результат


        int s1 = 0;
        String s2 = null;
        String s3 = null;
        while (result.next()){
            s1 = result.getInt(1);
            s2 = result.getString(2);
            s3 = result.getString(3);
        }
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("_______");
        Word word = new Word(s1,s2,s3);

        //эта хуета не работает
        //System.out.println(result.getInt(1));
            //result.getInt("id"),
            //result.getString("value"),
            //result.getString("translate"));


        return word;
    }

}
