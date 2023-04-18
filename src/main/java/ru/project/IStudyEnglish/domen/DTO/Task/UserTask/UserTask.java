package ru.project.IStudyEnglish.domen.DTO.Task.UserTask;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.domen.DTO.Task.Task;
import ru.project.IStudyEnglish.domen.DTO.Task.ForRepetition.TaskForRepetition;
import ru.project.IStudyEnglish.infrastructure.DAO.UserTaskDAO;
import ru.project.IStudyEnglish.infrastructure.repository.SourceUserTask;

@Log4j2
public class UserTask extends Task{
    private String id;
    private String userCode;
    private Task task;
    private String status;
    private UserTaskStatusEnum statusEnum;
    private String timeLastRepetition;
    private String timeNextRepetition;
    private String correctAttemptsCounter;
    private SourceUserTask data;

    public UserTask(){

    }

    public UserTask(String id){
        this.data = new UserTaskDAO(id);
        this.id = id;
        this.userCode = data.getUserCode();
        this.status = data.getStatus();
        this.timeLastRepetition = data.getTimeLastRepetition();
        this.timeNextRepetition = data.getTimeNextRepetition();
        this.correctAttemptsCounter = data.getCorrectAttemptsCounter();
        this.task = new TaskForRepetition(data.getIdTask());

    }



    public String getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }

    public String processingCorrectAnswer(String id){
        return null;
    }

    public String processingInCorrectAnswer(String id){
        return null;
    }
    public void updateStatus(){
        log.error("updateStatus");
        data.setStatus("8");
    }



}

