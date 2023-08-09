package ru.project.IStudyEnglish.learning_module.repository.Answer;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class AnswersListDAO {
    private JdbcTemplate jdbcTemplate;
    private ListAnswersMapper listAnswersMapper;

    @Autowired
    public AnswersListDAO(JdbcTemplate jdbcTemplate, ListAnswersMapper listAnswersMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.listAnswersMapper = listAnswersMapper;
    }

    public List<Integer> get(int id) {
        String sql =
                "SELECT * " +
                        "FROM  answer_and_similar " +
                        "where answer_true = (?) ";


        return jdbcTemplate.query(sql, new Object[]{id}, listAnswersMapper )
                .stream().findAny().orElse(null);
    }

    public void  create(int id_true, String id_answer){
        String sql = "insert into answer_and_similar (answer_true,similar_str) " +
                "values ('"+ String.valueOf(id_true) + "','" + id_answer +"');";
        jdbc(sql);
    }


    public void jdbc(String sql){
        log.info("run save answer");
        try {
            jdbcTemplate.update(sql);
        }
        catch (Exception e){}

    }


}
