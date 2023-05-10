package ru.project.IStudyEnglish.domen.DTO.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.domen.DTO.Answer.ListAnswers;
import ru.project.IStudyEnglish.infrastructure.SourceTask;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.DAO.TaskDAO;


@Component
public class Task {
    private int id;
    //TODO DI
    //private TypeTask typeTask;
    //private Question question;
    private ListAnswers listAnswers;
    //TODO сделать заполнение из списка
    private String translationDirection;
    private SourceTask data;

    public Task(){

    }

    @Autowired
    public Task(TaskDAO taskDAO,ListAnswers listAnswers) {
        this.data = taskDAO;
        this.listAnswers = listAnswers;
    }

    public Task(int id) {
        fillOnId(id);
    }

    public void fillOnId(int id){
        data.fillOnId(id);
        this.id = this.data.getId();
        //this.typeTask = TypeTask.valueOf(this.date.getTypeTask());
       // this.question = new Question(this.date.getQuestion());
        this.listAnswers.fill(
                this.data.getListTrueAnswers(),
                this.data.getListFalseAnswers());
        this.translationDirection = this.data.getTranslationDirection();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public TypeTask getTypeTask() {
//        return typeTask;
//    }
//
//    public void setTypeTask(TypeTask typeTask) {
//        this.typeTask = typeTask;
//    }
//
//    public Question getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(Question question) {
//        this.question = question;
//    }

    public ListAnswers getListAnswers() {
        return listAnswers;
    }

    public void setListAnswers(ListAnswers listAnswers) {
        this.listAnswers = listAnswers;
    }

    public String getTranslationDirection() {
        return translationDirection;
    }

    public void setTranslationDirection(String translationDirection) {
        this.translationDirection = translationDirection;
    }
}
