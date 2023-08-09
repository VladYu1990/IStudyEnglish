package ru.project.IStudyEnglish.learning_module.repository.ListAnswers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Answer.Answer;

import java.util.List;

@Component
public class ListAnswersDAO {
    private JdbcTemplate jdbcTemplate;
    private ListAnswersMapper listAnswersMapper;

    @Autowired
    public ListAnswersDAO(JdbcTemplate jdbcTemplate, ListAnswersMapper listAnswersMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.listAnswersMapper = listAnswersMapper;
    }

    public List<Answer> getList(String correctAnswer) {
        String sql =
                "SELECT * " +
                        "FROM  answer_and_similar" +
                        "where answer_true = (?) ";


        return jdbcTemplate.query(sql, new Object[]{correctAnswer}, listAnswersMapper )
                .stream().findAny().orElse(null);
    }
}
