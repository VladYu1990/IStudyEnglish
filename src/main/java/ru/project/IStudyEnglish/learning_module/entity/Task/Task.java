package ru.project.IStudyEnglish.learning_module.entity.Task;

import ru.project.IStudyEnglish.learning_module.entity.Answer.Answer;
import ru.project.IStudyEnglish.learning_module.entity.TypeSource;

import java.sql.Timestamp;
import java.util.List;


public class Task {
    private int id;

    private TypeTask typeTask;
    private String question;
    private List<Answer> listAnswers;
    private TranslationDirection translationDirection;
    private Timestamp created;
    private Timestamp updated;

    private int idSource;

    private TypeSource typeSource;


    public List<Answer> getListAnswers() {
        return listAnswers;
    }

    public void setListAnswers(List<Answer> listAnswers) {
        this.listAnswers = listAnswers;
    }

    public Task(){

    }

    public Task(TypeTask typeTask,  TranslationDirection translationDirection, String question, int idSource, TypeSource typeSource) {
        this.typeTask = typeTask;
        this.question = question;
        this.translationDirection = translationDirection;
        this.idSource = idSource;
        this.typeSource = typeSource;
        this.updated = new Timestamp(System.currentTimeMillis());
        this.created = new Timestamp(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public TranslationDirection getTranslationDirection() {
        return translationDirection;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setTranslationDirection(TranslationDirection translationDirection) {
        this.translationDirection = translationDirection;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(TypeTask typeTask) {
        this.typeTask = typeTask;
    }

    public int getIdSource() {
        return idSource;
    }

    public void setIdSource(int idSource) {
        this.idSource = idSource;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public TypeSource getTypeSource() {
        return typeSource;
    }

    public void setTypeSource(TypeSource typeSource) {
        this.typeSource = typeSource;
    }
}
