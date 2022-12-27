package ru.project.IStudyEnglish.DTO;


public class RepetitionExercise {
    private int idStudyTask; //храним в бд
    private Question question;
    private ListAnswers listAnswers;

    public RepetitionExercise(){
        this.idStudyTask = 12;
        this.question = new Question();
        this.listAnswers = new ListAnswers();
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