package ru.project.IStudyEnglish.domen.DTO.Task;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.infrastructure.DAO.UserTaskDAO;
import ru.project.IStudyEnglish.infrastructure.repository.SourceUserTask;

import java.sql.Timestamp;

@Log4j2
public class UserTask {
    private String id;
    private String userId;
    private Task task;
    private String status;
    private UserTaskStatusEnum statusEnum;
    private Timestamp timeLastRepetition;
    private Timestamp timeNextRepetition;
    private String correctAttemptsCounter;
    private SourceUserTask data = new UserTaskDAO();

    public UserTask() {

    }

    public void fillById(String taskId) {
        data.fillById(taskId);
        fillFromData();

    }

    public void fillNext(String idUser) {
        data.fillNextForUser(idUser);
        fillFromData();

    }

    private void fillFromData(){
        this.id = data.getId();
        this.userId = data.getUserCode();
        this.status = data.getStatus();
        this.timeLastRepetition = data.getTimeLastRepetition();
        this.timeNextRepetition = data.getTimeNextRepetition();
        this.correctAttemptsCounter = data.getCorrectAttemptsCounter();
        this.task = new Task(this.id);
    }



    public static void update(String idUserTask,Boolean answerIsTrue){
        //TODO реализацию метода

    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Task getTask() {
        return task;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}


