package ru.project.IStudyEnglish.domen.DTO.Questions;

import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.DAO.QuestionDAO;
import ru.project.IStudyEnglish.infrastructure.SourceQuestion;

@Component
public class Question {
    private int id;
    private String value;
    private SourceQuestion data = new QuestionDAO();

    public Question(){

    }

    public Question(String id){
        data.getOnId(id);
        fillFromData();
    }


    private void fillFromData() {
        this.id = this.data.getId();
        this.value = this.data.getValue();

    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}