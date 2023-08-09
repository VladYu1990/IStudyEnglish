package ru.project.IStudyEnglish.learning_module.repository.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ListAnswersMapper implements RowMapper<List<Integer>>{

    @Autowired
    public ListAnswersMapper() {
    }

        @Override
        public List<Integer> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            List<Integer> list = new ArrayList<>();

            list.add(resultSet.getInt("answer_true"));

            List<String> list1 = Arrays.asList(resultSet.getString("similar_str").split(";"));

            for(int i = 0; i < list1.size(); i++) {
                list.add(Integer.valueOf(list1.get(i)));
            }
            return list;
        }
    }



