package ru.project.IStudyEnglish.like_it_module.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Answer.AnswerOnQuestion;
import ru.project.IStudyEnglish.like_it_module.entity.SimilarityAnswer;

import java.util.List;

@Component
@Log4j2
public class AnswersListDAO {
    private JdbcTemplate jdbcTemplate;
    private AnswersOnQuestionMapper answersOnQuestionMapper;

    @Autowired
    public AnswersListDAO(JdbcTemplate jdbcTemplate, AnswersOnQuestionMapper answersOnQuestionMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.answersOnQuestionMapper = answersOnQuestionMapper;
    }

    //todo разделить на 2 класса, ответы на вопросы и похожие вопросы
    public List<AnswerOnQuestion> get(int id,int count) {
        String sql =
                        "select id, a.value, 'true' bool, 100 similarity \n" +
                        "from \n" +
                        "answers a\n" +
                        "where a.id  = "+id+"\n" +
                        "union all \n" +
                        "select similar_id  id, a.value, 'false' bool, similarity  \n" +
                        "from answer_and_similar aas,\n" +
                        "answers a\n" +
                        "where a.id =aas.similar_id\n" +
                        "and aas.answer_id  = " + id +"\n" +
                        "order by similarity desc limit "+ count;
        return jdbcTemplate.query(sql, answersOnQuestionMapper);
    }

    public void  create(List<SimilarityAnswer> similarity){
        String sql = "";
        for (int i=0;i<similarity.size();i++) {
            sql = sql + "insert into answer_and_similar " +
                    "(answer_id,similar_id,similarity) " +
                    "values " +
                    "(" + similarity.get(i).id + ","
                    + similarity.get(i).similar_id + ","
                    + similarity.get(i).similarity + ");";


        }
        jdbc(sql);
    }


    public void jdbc(String sql){
        try {
            jdbcTemplate.update(sql);
        }
        catch (Exception e){}

    }


    public void truncateTable() {

        String sql = "TRUNCATE answer_and_similar";
        try {
            jdbcTemplate.update(sql);
        }
        catch (Exception e){}
    }
}
