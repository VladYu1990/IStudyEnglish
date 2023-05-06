package ru.project.IStudyEnglish.domen.DTO.Answer;

import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.infrastructure.DAO.AnswerDAO;
import ru.project.IStudyEnglish.infrastructure.SourceAnswer;


@Component
public class Answer {
    private int id;
    private String value;
    private boolean correct;
    private SourceAnswer data;


    public Answer() {

    }

    public Answer(String id,boolean correct) {
        //TODO получаем из бд
        this.data = new AnswerDAO(id);
        this.id = this.data.getId();
        this.value = this.data.getValue();
        this.correct = correct;

    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public boolean isCorrect() {
        return correct;
    }
}
