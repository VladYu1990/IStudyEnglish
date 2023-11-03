package ru.project.IStudyEnglish.like_it_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Answer.AnswerOnQuestion;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AnswersOnQuestionMapper implements RowMapper<AnswerOnQuestion>{

    @Autowired
    public AnswersOnQuestionMapper() {
    }

        @Override
        public AnswerOnQuestion mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new AnswerOnQuestion(
                    resultSet.getInt("id"),
                    resultSet.getString("value"),
                    resultSet.getBoolean("bool"));
        }
    }



