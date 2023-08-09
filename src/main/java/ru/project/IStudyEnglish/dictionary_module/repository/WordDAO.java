package ru.project.IStudyEnglish.dictionary_module.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.entity.Word;
import ru.project.IStudyEnglish.dictionary_module.repository.WordMapper;
import ru.project.IStudyEnglish.dictionary_module.repository.SourceWord;

@Component
public class WordDAO implements SourceWord {

    private JdbcTemplate jdbcTemplate;
    private WordMapper wordMapper;

    @Autowired
    public WordDAO(JdbcTemplate jdbcTemplate, WordMapper wordMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.wordMapper = wordMapper;
    }

    @Override
    public Word getOnId(int id) {

        String sql = "SELECT * FROM words WHERE id in (?) limit 1";
        //TODO повторяется
        return jdbcTemplate.query(sql, new Object[]{id}, wordMapper)
                .stream().findAny().orElse(null);
    }
}
