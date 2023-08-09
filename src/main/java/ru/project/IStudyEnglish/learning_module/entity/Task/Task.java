package ru.project.IStudyEnglish.learning_module.entity.Task;

import ru.project.IStudyEnglish.dictionary_module.entity.Source;

import java.sql.Timestamp;


public class Task {
    private int id;

    private TypeTask typeTask;
    private TranslationDirection translationDirection;
    private String question;
    private int trueAnswer;
    private Timestamp created;
    private Timestamp updated;
    private Source source;


    public Task(){
    }

    public Task(TypeTask typeTask, TranslationDirection translationDirection,String question, int trueAnswer, Source source) {
        this.typeTask = typeTask;
        this.translationDirection = translationDirection;
        this.question = question;
        this.trueAnswer = trueAnswer;
        this.source = source;
        this.updated = new Timestamp(System.currentTimeMillis());
        this.created = new Timestamp(System.currentTimeMillis());
    }

    public Task(int id, TypeTask typeTask, String question, int trueAnswer, TranslationDirection translationDirection, Timestamp created, Timestamp updated, Source source) {
        this.id = id;
        this.typeTask = typeTask;
        this.question = question;
        this.trueAnswer = trueAnswer;
        this.translationDirection = translationDirection;
        this.created = created;
        this.updated = updated;
        this.source = source;
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

    public TranslationDirection getTranslationDirection() {
        return translationDirection;
    }

    public void setTranslationDirection(TranslationDirection translationDirection) {
        this.translationDirection = translationDirection;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getTrueAnswer() {
        //TODO
        return trueAnswer;
    }

    public void setTrueAnswer(int trueAnswer) {
        this.trueAnswer = trueAnswer;
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

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
