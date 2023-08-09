package ru.project.IStudyEnglish.dictionary_module.repository;

import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.entity.PartOfSpeech;
import ru.project.IStudyEnglish.dictionary_module.entity.Word;
import ru.project.IStudyEnglish.learning_module.entity.TypeSource;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Log4j2
public class WordMapper implements RowMapper<Word> {

    private Word word = new Word();

    public WordMapper() {
    }


    @Override
    public Word mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        word = new Word();

        try {
            this.word.setId(resultSet.getInt("id"));
            this.word.setRusTextStr(resultSet.getString("rus_text"));
            this.word.setEngTextStr(resultSet.getString("eng_text"));
            this.word.setPartOfSpeech(
                    PartOfSpeech.valueOf(
                            resultSet.getString("part_of_speech")));
            this.word.setTypeSource(TypeSource.word);
            return this.word;
        }
        catch (Exception e){
            log.info(resultSet.getString("part_of_speech"));
        }
        return null;
    }
}