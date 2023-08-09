package ru.project.IStudyEnglish.learning_module.entity.UserTask;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.learning_module.entity.User.User;

import java.sql.Timestamp;

import static ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTaskStatusEnum.readyToExplore;

@Log4j2
@Component
public class UserTask {
    private int id;
    private int idUser;
    private int idTask;
    private UserTaskStatusEnum status;
    private Timestamp timeLastRepetition;
    private Timestamp timeNextRepetition;
    private int correctAttemptsCounter;


    public UserTask() {
    }

    public UserTask(User user,Task task){
        this.idUser = user.getId();
        this.idTask = task.getId();
        fill();
    }

    public UserTask(int idUser,int idTask){
        this.idUser = idUser;
        this.idTask = idTask;
        fill();
    }

    private void fill(){
        this.status = readyToExplore;
        this.timeLastRepetition = new Timestamp(System.currentTimeMillis());
        this.timeNextRepetition = new Timestamp(System.currentTimeMillis());
        this.correctAttemptsCounter = 0;
    }


     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
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

    public int getCorrectAttemptsCounter() {
        return correctAttemptsCounter;
    }

    public void setCorrectAttemptsCounter(int correctAttemptsCounter) {
        this.correctAttemptsCounter = correctAttemptsCounter;
    }
}


