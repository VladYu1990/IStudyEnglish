package ru.project.IStudyEnglish.dictionary_module.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.entity.Word;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class WordMapper implements RowMapper<Word> {

    private Word word = new Word();

    public WordMapper() {
    }


    @Override
    public Word mapRow(ResultSet resultSet, int rowNum) throws SQLException {


        word.setId(resultSet.getInt("id"));
        word.setValueRUS(resultSet.getString("valueRUS"));
        word.setValueENG(resultSet.getString("valueENG"));
        word.setCode_of_part_speech(resultSet.getInt("code_of_part_speech"));
        return word;
    }
}