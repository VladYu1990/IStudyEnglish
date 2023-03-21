package ru.project.IStudyEnglish.DAO;

import ru.project.IStudyEnglish.infrastructure.ConnectDB;
import ru.project.IStudyEnglish.infrastructure.SourceData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@Entity
@Table(name="word")
public class WordDAO implements SourceData {
    @Id
    @Column(name = "id")
    public int id;
    @Column
    public String writing;
    @Column
    public String value;
    @Column
    public String likeThisWord;
    String sql = "Select * from word where id=";


    public WordDAO() {

    }

    @Override
    public String getData() {
        return null;
    }

    @Override
    public String getData(int id) throws SQLException {
        ConnectDB conDB = new ConnectDB();
        Statement statement = conDB.getStatement();
        sql = sql + String.valueOf(id);//"+String.valueOf(number_word);

        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            id = result.getInt("id");
            this.writing = result.getString(2);
            this.value = result.getString(3);
            this.likeThisWord = result.getString(4);
            return "test";
        }
        return null;
    }


    @Override
    public String getDataNext() {
        return null;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getWriting() {
        return this.writing;
    }

    @Override
    public String getLikeThisWord() {
        return this.likeThisWord;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public void setId(int id) {
        this.id = id;
    }
}
