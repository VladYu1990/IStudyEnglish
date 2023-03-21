package ru.project.IStudyEnglish.DTO;


import java.sql.SQLException;

public class RepetitionExercise {
    private int idStudyTask; //храним в бд
    private Question question;
    private ListAnswers listAnswers;
    private String TypeTopic;

    public RepetitionExercise() throws SQLException {
        this.idStudyTask = 12;
        this.question = new Question();
    }

    public int getIdStudyTask() {
        return idStudyTask;
    }

    public void setIdStudyTask(int idStudyTask) {
        this.idStudyTask = idStudyTask;
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
}