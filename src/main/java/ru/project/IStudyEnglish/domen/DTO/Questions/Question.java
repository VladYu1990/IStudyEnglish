package ru.project.IStudyEnglish.domen.DTO.Questions;

import ru.project.IStudyEnglish.infrastructure.DAO.QuestionDAO;
import ru.project.IStudyEnglish.infrastructure.repository.SourceQuestion;

public class Question {
    private String id;
    private String value;
    private SourceQuestion data = new QuestionDAO();

    public Question(String id){
        data.getOnId(id);
        fillFromData();
    }


    private void fillFromData() {
        this.id = this.data.getId();
        this.value = this.data.getValue();

    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}