package ru.project.IStudyEnglish.learning_module.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.controller.GetUser;
import ru.project.IStudyEnglish.learning_module.controller.UserTaskDTO;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;
import ru.project.IStudyEnglish.learning_module.service.Answer.AnswerChecker;
import ru.project.IStudyEnglish.learning_module.service.UserTask.UserTackDAOAdapter;
import ru.project.IStudyEnglish.learning_module.service.UserTask.CreatorUserTask;
import ru.project.IStudyEnglish.learning_module.service.UserTask.VoterNextUserTask;
import ru.project.IStudyEnglish.user_module.entity.User.User;

@Component
@Log4j2
public class UserTaskApiAdapter {

    GetUser getUser;
    UserTackDAOAdapter userTackDAOAdapter;
    VoterNextUserTask voterNextUserTask;
    UserTaskDTO userTaskDTO;
    AnswerChecker answerChecker;
    CreatorUserTask creatorUserTask;
    User user = new User();
    UserTask userTask = new UserTask();

    public UserTaskApiAdapter() {
    }

    @Autowired
    public UserTaskApiAdapter(GetUser getUser, UserTackDAOAdapter userTackDAOAdapter, VoterNextUserTask voterNextUserTask, UserTaskDTO userTaskDTO, AnswerChecker answerChecker, CreatorUserTask creatorUserTask) {
        this.getUser = getUser;
        this.userTackDAOAdapter = userTackDAOAdapter;
        this.voterNextUserTask = voterNextUserTask;
        this.userTaskDTO = userTaskDTO;
        this.answerChecker = answerChecker;
        this.creatorUserTask = creatorUserTask;
    }

    public void createAll(String token){
        user = getUser.get(token);
        creatorUserTask.createAll(user);
    }

    public UserTaskDTO getNextUserTask(String token){
        try {
            user = getUser.get(token);
            getUt(userTaskDAO.getNext(user));//тут надо сделать не дао о порт
            userTaskDTO.setUserTask(userTask);
            return userTaskDTO;
        }
        catch (Exception e){
            log.info(e);
            return null;}
    }

    public UserTaskDTO getUserTask(String token,int id) {
        try {
            getUser.get(token);
            getUt(id);
            userTaskDTO.setUserTask(userTask);
            return userTaskDTO;
        }
        catch (Exception e){
            return null;}
    }

    public void response(String token,int idUserTask, int idResponse){
            getUser.get(token);
            answerChecker.check(idUserTask,idResponse);
    }

    private void getUt(int id){
        userTask = userTackDAOAdapter.get(id);
    }
}

