package ru.project.IStudyEnglish.learning_module.repository.Answer;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Answer.Answer;

@Log4j2
@Component
public class AnswerDAO implements SourceAnswer {

    private JdbcTemplate jdbcTemplate;
    private AnswerMapper answerMapper;

    public AnswerDAO() {
    }

    @Autowired
    public AnswerDAO(JdbcTemplate jdbcTemplate, AnswerMapper answerMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.answerMapper = answerMapper;
    }

    public Answer getOnId(int idAnswer) {
        String sql = "SELECT * FROM answers WHERE id = ?";

        return jdbcTemplate.query(sql,new Object[]{idAnswer}, answerMapper)
                .stream().findAny().orElse(null);
    }

    @Override
    public Answer getOnValue(String value) {
        String sql = "SELECT * FROM answers WHERE value in (?)";

        try {
            return jdbcTemplate.query(sql,new Object[]{value}, answerMapper)
                    .stream().findAny().orElse(null);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public void create(String value) {
        String sql = "INSERT INTO answers VALUES(nextval('id_answers'),?)";//
        jdbcTemplate.update(sql,
                new Object[]{value});
    }
}
