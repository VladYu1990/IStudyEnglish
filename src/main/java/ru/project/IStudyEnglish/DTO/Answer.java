package ru.project.IStudyEnglish.DTO;

import ru.project.IStudyEnglish.core.WordForRepetition;

import java.sql.SQLException;

public class Answer {
    private String value;

    public Answer(int idWord) throws SQLException {
        WordForRepetition w = new WordForRepetition(idWord);
        this.value="тестовое значение";

    }

    static String getAnswer(int idWord) throws SQLException {
        Word word = new Word(idWord);
       return word.value;
    }


    public String getValue() {
        return null;
    }
}
