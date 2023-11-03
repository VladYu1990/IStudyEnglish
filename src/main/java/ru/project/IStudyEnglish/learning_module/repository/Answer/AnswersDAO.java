package ru.project.IStudyEnglish.learning_module.repository.Answer;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Answer.Answer;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class AnswersDAO {
    private JdbcTemplate jdbcTemplate;
    private AnswerMapper answerMapper;

    @Autowired
    public AnswersDAO(JdbcTemplate jdbcTemplate, AnswerMapper answerMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.answerMapper = answerMapper;
    }

    public Answer get(int id){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(id);
        return get(integerList).get(0);
    }

    public List<Answer> get(List<Integer> intList) {
        String sql =
                "SELECT * " +
                        "FROM  answers " +
                        "where id in (" + intList.get(0);
        String str = "";
        for(int i = 1; i<intList.size();i++){
            str= str + "," + intList.get(i);
        }
        sql = sql + str + ");";

        return jdbcTemplate.query(sql, answerMapper);
    }

    public Answer get(String str){
        List<String> integerList = new ArrayList<>();
        integerList.add(str);
        return getByValue(integerList).get(0);
    }

    public List<Answer> getByValue(List<String> strList) {
        strList.size();
        String sql =
                "SELECT * " +
                        "FROM  answers " +
                        "where value in ('";
        for(int i = 0;i<strList.size()-1;i++){
            sql = sql + strList.get(i) + "',''";
        }

        sql = sql + strList.get(strList.size()-1) + "');";


        return jdbcTemplate.query(sql, answerMapper);
    }

    public void  create(Answer answer){
        jdbc(generateSql(answer));
    }


    public void  create(List<Answer> answerList){
        for (int i=0;i<answerList.size();i++){
            jdbc(generateSql(answerList.get(i)));
        }
    }

    private String generateSql(Answer answer){
        String sql = "insert into answers (id,value,type) " +
                "values (nextval('id_answers'),'" + answer.getValue() + "','" + answer.getTypeAnswer() + "');";
        return sql;
    }

    private void jdbc(String sql){
        try {
            jdbcTemplate.update(sql);
        }
        catch (Exception e){}

    }


    public List<Answer> getAll() {
        String sql =
                "SELECT * " +
                        "FROM  answers ";
        return jdbcTemplate.query(sql, answerMapper);
    }
}
