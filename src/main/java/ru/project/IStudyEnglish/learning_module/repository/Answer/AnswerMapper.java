package ru.project.IStudyEnglish.learning_module.repository.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Answer.Answer;
import ru.project.IStudyEnglish.learning_module.entity.Answer.TypeAnswer;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AnswerMapper implements RowMapper<Answer> {

    @Autowired
    public AnswerMapper() {
    }

    @Override
    public Answer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Answer answer = new Answer();
        answer.setId(resultSet.getInt("id"));
        answer.setValue(resultSet.getString("value"));
        answer.setTypeAnswer(
                TypeAnswer.valueOf(
                        resultSet.getString("type")));

        return answer;
    }
}
