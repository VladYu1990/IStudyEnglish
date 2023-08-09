package ru.project.IStudyEnglish.learning_module.entity.UserTask;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.user_module.entity.User.User;

import java.sql.Timestamp;

import static ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTaskStatusEnum.readyToExplore;

@Log4j2
@Component
public class UserTask {
    private int id;
    private User user;
    private Task task;
    private UserTaskStatusEnum status;
    private Timestamp timeLastRepetition;
    private Timestamp timeNextRepetition;
    private Timestamp timeCreated;
    private Timestamp timeUpdated;
    private int correctAttemptsCounter;


    public UserTask() {
    }

    public UserTask(int id, User user, Task task, UserTaskStatusEnum status, Timestamp timeLastRepetition, Timestamp timeNextRepetition, Timestamp timeCreated, Timestamp timeUpdated, int correctAttemptsCounter) {
        //генерит таску из хранилища
        this.id = id;
        this.user = user;
        this.task = task;
        this.status = status;
        this.timeLastRepetition = timeLastRepetition;
        this.timeNextRepetition = timeNextRepetition;
        this.timeCreated = timeCreated;
        this.timeUpdated = timeUpdated;
        this.correctAttemptsCounter = correctAttemptsCounter;
    }

    public UserTask(User user, Task task){
        //используется для создания новой таски
        this.user = user;
        this.task = task;
        fill();
    }


    private void fill(){
        this.status = readyToExplore;
        this.timeLastRepetition = new Timestamp(System.currentTimeMillis());
        this.timeNextRepetition = new Timestamp(System.currentTimeMillis());
        this.timeCreated = new Timestamp(System.currentTimeMillis());
        this.timeUpdated = new Timestamp(System.currentTimeMillis());
        this.correctAttemptsCounter = 0;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserTaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserTaskStatusEnum status) {
        this.status = status;
    }

    public Timestamp getTimeLastRepetition() {
        return timeLastRepetition;
    }

    public void setTimeLastRepetition(Timestamp timeLastRepetition) {
        this.timeLastRepetition = timeLastRepetition;
    }

    public Timestamp getTimeNextRepetition() {
        return timeNextRepetition;
    }

    public void setTimeNextRepetition(Timestamp timeNextRepetition) {
        this.timeNextRepetition = timeNextRepetition;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Timestamp getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Timestamp timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public int getCorrectAttemptsCounter() {
        return correctAttemptsCounter;
    }

    public void setCorrectAttemptsCounter(int correctAttemptsCounter) {
        this.correctAttemptsCounter = correctAttemptsCounter;
    }
}


