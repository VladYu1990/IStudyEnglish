package ru.project.IStudyEnglish.core;

import ru.project.IStudyEnglish.DTO.Word;

import java.sql.SQLException;

public class WordForRepetition extends Word {
    public int id;
    String writing;
    String value;
    public WordForRepetition() throws SQLException {
        /*Statement statement = ConnectDB.getStatement();

        String sql = "Select * from word where id=2";//"+String.valueOf(number_word);

        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            id = result.getInt("id");
            writing = result.getString(3);
            value = result.getString(3);
        }*/
    }

   public WordForRepetition(int idWord) throws SQLException {
        /*Statement statement = ConnectDB.getStatement();

        String sql = "Select * from word where id="+String.valueOf(idWord);//"+String.valueOf(number_word);

        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            id = result.getInt("id");
            writing = result.getString(3);
            value = result.getString(3);
        }*/
    }

    public WordForRepetition(int id, String value,String writing) {
        this.id = id;
        this.value = value;
        this.writing = writing;

    }


}
