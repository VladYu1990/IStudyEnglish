package ru.project.IStudyEnglish.domen.DTO.Task;

import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.domen.DTO.Answer.ListAnswers;
import ru.project.IStudyEnglish.domen.DTO.Questions.Question;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.DAO.TaskDAO;
import ru.project.IStudyEnglish.infrastructure.SourceTask;



@Component
public class Task {
    private int id;
    private TypeTask typeTask;
    private Question question;
    private ListAnswers listAnswers;
    //TODO сделать заполнение из списка
    private String translationDirection;
    private SourceTask date;

    public Task(){

    }


    public Task(int id){
        this.date = new TaskDAO(id);
        this.id = this.date.getId();
        this.typeTask = TypeTask.valueOf(this.date.getTypeTask());
        this.question = new Question(this.date.getQuestion());
        this.listAnswers = new ListAnswers(
                this.date.getListTrueAnswers(),
                this.date.getListFalseAnswers());
        this.translationDirection = this.date.getTranslationDirection();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(TypeTask typeTask) {
        this.typeTask = typeTask;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

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
