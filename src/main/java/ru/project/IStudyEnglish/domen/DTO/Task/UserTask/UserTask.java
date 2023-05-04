package ru.project.IStudyEnglish.domen.DTO.Task.UserTask;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.domen.DTO.Task.Task;
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
//        SourceUserTask data = new UserTaskDAO(id);
//        this.id = id;
//        this.userCode = data.getUserCode();
//        this.status = data.getStatus();
//        this.timeLastRepetition = data.getTimeLastRepetition();
//        this.timeNextRepetition = data.getTimeNextRepetition();
//        this.correctAttemptsCounter = data.getCorrectAttemptsCounter();
//        //this.task = new TaskForRepetition(data.getIdTask());

    }

    private void getData(String id){
        data.getById(id);
    }


    public UserTask fillNext(String idUser) {

        return this;
    }



    public static void update(String idUserTask,Boolean answerIsTrue){
        //TODO реализацию метода

    }
}


