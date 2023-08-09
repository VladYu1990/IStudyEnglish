package ru.project.IStudyEnglish.dictionary_module.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.entity.Word;

import java.util.List;

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
    public Word get(int id) {

        String sql = "SELECT * FROM words WHERE id = (?) limit 1";
        return jdbcTemplate.query(sql, new Object[]{id}, wordMapper)
                .stream().findAny().orElse(null);
    }

    @Override
    public List<Word> get() {
        String sql = "SELECT * FROM words";
        //TODO повторяется
        return jdbcTemplate.query(sql,wordMapper);
    }

    public void save(Word word) {
        jdbsUpdate(createSQL(word));
    }

    public void save(List<Word> wordList) {

        for (int i = 0; i < wordList.size(); i++) {
            jdbsUpdate(createSQL(wordList.get(i)));
        }
    }

    private String createSQL(Word word) {
        String sql =
                "insert into words  (" +
                        "id," +
                        "rus_text, " +
                        "eng_text, " +
                        "rus_sound, " +
                        "eng_sound, " +
                        "part_of_speech) " +
                        "values ( " +
                        "nextval('id_words')," +
                        "'" + word.getRusTextStr() + "'," +
                        "'" + word.getEngTextStr() + "'," +
                        "'" + word.getRusSoundStr() + "'," +
                        "'" + word.getEngSoundStr() + "'," +
                        "'" + word.getPartOfSpeech() + "');";
        return sql;
    }

    private void jdbsUpdate(String sql){
        try {
            jdbcTemplate.update(sql);
        }
        catch (Exception e){}
    }
}
