package ru.project.IStudyEnglish.DTO;

import ru.project.IStudyEnglish.DAO.WordDAO;
import ru.project.IStudyEnglish.infrastructure.SourceData;

import java.sql.SQLException;

public class Word extends Question{
    public int id;
    public String writing;
    public String value;
    public String likeThisWord;
    //private String spelling;
    //private String partOfSpeech;
    //добавить тему слова - архитектура, погода, работа и тд

    public String getTranslate() {
        return value;
    }

    public void setTranslate(String value) {
        this.value = value;
    }

    public Word() {
        this.id = 1;
        this.writing = "это слово2";
        this.value = "";

    }
    public Word(int id) throws SQLException {
        SourceData date = new WordDAO();
        date.getData(id);
        this.id = date.getId();
        this.writing = date.getWriting();
        this.value = date.getValue();
        this.likeThisWord=date.getLikeThisWord();


    }




}
