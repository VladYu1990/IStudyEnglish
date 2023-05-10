package ru.project.IStudyEnglish.domen.DTO.Task;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.infrastructure.SourceUserTask;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.DAO.UserTaskDAO;

import java.sql.Timestamp;

@Log4j2
public class UserTask {
    private int id;
    private int userId;
    private Task task;
    private int status;
    private UserTaskStatusEnum statusEnum;
    private Timestamp timeLastRepetition;
    private Timestamp timeNextRepetition;
    private int correctAttemptsCounter;
    private SourceUserTask data = new UserTaskDAO(); //TODO тут быть не должно


    public UserTask() {

    }

    public UserTask(UserTaskDAO userTaskDAO){

    }

    public void getOnId(int taskId) {
        data.getOnId(taskId);
        fillFromData();

    }

    public void fillNext(String idUser) {
        data.getNext(idUser);
        fillFromData();

    }

    private void fillFromData(){
        this.id = data.getId();
        this.userId = data.getUserCode();
        this.status = data.getStatus();
        this.timeLastRepetition = data.getTimeLastRepetition();
        this.timeNextRepetition = data.getTimeNextRepetition();
        this.correctAttemptsCounter = Integer.valueOf(data.getCorrectAttemptsCounter());
        this.task = new Task(data.getIdTask());
    }

    public void update(Boolean answerIsCorrect) {
        //TODO вынести в конфиги или отдельну функции расчет времени смешения
        // в зависимости от кол-ва успешных повторений
        int daysAfterCorrect = 7;
        int daysAfterIncorrect = 2;
        //TODO добавить метод в котором будет логика апдейта статуса
        this.timeLastRepetition = new Timestamp(System.currentTimeMillis());
        if (answerIsCorrect == true) {
            //TODO что-то надо сделать с умножением
            this.timeNextRepetition.setTime(System.currentTimeMillis() + daysAfterCorrect*24*60*60*1000);
            this.correctAttemptsCounter = this.correctAttemptsCounter + 1;

        } else {
            this.timeNextRepetition = new Timestamp(System.currentTimeMillis()+daysAfterIncorrect*24*60*60*1000);
            this.correctAttemptsCounter = 0;
        }

        data.setStatus(this.status);
        data.setTimeLastRepetition(this.timeLastRepetition);
        data.setTimeNextRepetition(this.timeNextRepetition);
        data.setCorrectAttemptsCounter(this.correctAttemptsCounter);
        data.update();
    }


    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Task getTask() {
        return task;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}


