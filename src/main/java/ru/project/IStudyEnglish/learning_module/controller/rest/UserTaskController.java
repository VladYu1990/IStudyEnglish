package ru.project.IStudyEnglish.learning_module.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.learning_module.controller.GetUserByTokenString;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;
import ru.project.IStudyEnglish.learning_module.service.Answer.AnswerChecker;
import ru.project.IStudyEnglish.learning_module.service.UserTask.BuilderUserTask;
import ru.project.IStudyEnglish.learning_module.service.UserTask.CreatorUserTask;
import ru.project.IStudyEnglish.learning_module.controller.UserTaskDTO;
import ru.project.IStudyEnglish.learning_module.service.UserTask.VoterNextUserTask;
import ru.project.IStudyEnglish.user_module.entity.User.User;

@RestController
@RequestMapping("/v1/{token}/user_tasks/")
@Log4j2
@Scope("prototype")
public class UserTaskController {

    @Autowired
    GetUserByTokenString getUserByTokenString;
    @Autowired
    BuilderUserTask builderUserTask;
    @Autowired
    VoterNextUserTask voterNextUserTask;
    @Autowired
    UserTaskDTO userTaskDTO;
    @Autowired
    AnswerChecker answerChecker;
    @Autowired
    CreatorUserTask creatorUserTask;


    @RequestMapping("/create/{source}/{id_source}/")
    public String createUserTask(@PathVariable String token, @PathVariable String source,@PathVariable int id_source) {
        //TODO
        return "ok";
    }

    @RequestMapping("/create_all/")
    public String createUserTaskAll(@PathVariable String token) {
        User user = getUserByTokenString.get(token);
        creatorUserTask.createAll(user);
        return "ok";
    }


    @RequestMapping("/next/get/")
    public UserTaskDTO getNextUserTask(@PathVariable String token) {

        try {
            User user = getUserByTokenString.get(token);
            UserTask userTask = builderUserTask.get(voterNextUserTask.getNext(user));
            this.userTaskDTO.setUserTask(userTask);
            log.info("дернули next " + this.userTaskDTO.getQuestion() +" " + this.userTaskDTO.getUserTaskId());
            return this.userTaskDTO;
            }
        catch (Exception e){
            log.info(e);
            return null;}

    }

    @RequestMapping("/get/{id}")
    public UserTaskDTO getNextUserTask(@PathVariable String token,@PathVariable int id) {
        try {
            User user = getUserByTokenString.get(token);
            UserTask userTask = builderUserTask.get(id);
            this.userTaskDTO.setUserTask(userTask);
            return this.userTaskDTO;
        }
        catch (Exception e){
            return null;}

    }

    @RequestMapping("/{id_user_task}/response/{id_response}")
    public String getNextUserTask(@PathVariable String token,@PathVariable int id_user_task,@PathVariable int id_response) {
        try {
            User user = getUserByTokenString.get(token);
            answerChecker.check(id_user_task,id_response);
            log.info("вернули ответ по UserTask" + id_user_task + " iaAnswer" + id_user_task);
            return "ok";
        }
        catch (Exception e){
            return "not ok";
        }

    }

}
