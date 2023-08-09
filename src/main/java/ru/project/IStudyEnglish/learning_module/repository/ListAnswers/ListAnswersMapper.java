package ru.project.IStudyEnglish.learning_module.repository.ListAnswers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import ru.project.IStudyEnglish.learning_module.entity.Answer.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAnswersMapper implements RowMapper<List<Answer>>{

    @Autowired
    public ListAnswersMapper() {
    }

        @Override
        public List<Answer> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        List<Answer> answerList = new ArrayList<>();
            answerList.add(
                    new Answer(resultSet.getString("answer_true"),true));

            List<String> stringList = Arrays.asList((resultSet.getString("similar_str").split(";")));


            for(int i = 0; i < stringList.size(); i++) {
                answerList.add(
                        new Answer(stringList.get(i),false));
            }
            return null;
        }
    }



