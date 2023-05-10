package ru.project.IStudyEnglish.domen.DTO.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.DAO.AnswerDAO;
import ru.project.IStudyEnglish.infrastructure.SourceAnswer;


@Component
@Scope("prototype")
public class Answer {
    private int id;
    private String value;
    private boolean correct;
    private SourceAnswer data;

    public Answer(){
    }

    @Autowired
    public Answer(AnswerDAO answerDAO){
        this.data = answerDAO;
    }

    public void fillOnId(int id,boolean correct) {
        //TODO получаем из бд
        this.data.fillOnId(id);
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
