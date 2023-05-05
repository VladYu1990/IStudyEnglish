package ru.project.IStudyEnglish.infrastructure.DAO;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.ConnectDB;
import ru.project.IStudyEnglish.infrastructure.repository.SourceData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.ResultSet;
import java.sql.SQLException;


@Entity
//@Table(name="word")
@Log4j2
public class WordDAO implements SourceData {
    @Id
    @Column//(name = "id")
    private int id;
    @Column
    public String writing;
    @Column
    public String value;
    @Column
    public String likeThisWord;
    String sql = "Select * from word where id in (";

    public WordDAO(String valueOf) {
    }

    public WordDAO() {

    }


    @Override
    public WordDAO WordDAO(String id) {
        sql = sql + String.valueOf(id) + ") limit 1";
        try {
            log.error("делаем коннект");
            ConnectDB conDB = new ConnectDB();
            log.error("коннект к бд выполнен, резаул получен");
            ResultSet result = conDB.getResultSet(sql);
            log.error(result.toString());

            while (result.next()) {
                this.id = result.getInt("id");
                this.writing = result.getString(2);
                this.value = result.getString(3);
                this.likeThisWord = result.getString(4);
            }
            return this;

        }
        catch (SQLException sqlException){
            log.error("не выполнено" + sql + sqlException.getMessage());
            return null;
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String getWriting() {
        return this.writing;
    }

    @Override
    public String getLikeThis() {
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
