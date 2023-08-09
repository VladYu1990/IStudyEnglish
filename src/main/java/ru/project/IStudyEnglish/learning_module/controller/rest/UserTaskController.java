package ru.project.IStudyEnglish.learning_module.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.dictionary_module.service.BuilderSource;
import ru.project.IStudyEnglish.learning_module.entity.TypeSource;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;
import ru.project.IStudyEnglish.learning_module.service.*;
import ru.project.IStudyEnglish.learning_module.service.object.UserTaskDTO;

@RestController
@RequestMapping("/v1/{token}/user_tasks/")
@Log4j2
@Scope("prototype")
public class UserTaskController {

    @Autowired
    private BuilderUserTask builderUserTask;
    @Autowired
    private BuilderTask builderTask;
    @Autowired
    private BuilderUser builderUser;
    @Autowired
    private BuilderToken builderToken;
    @Autowired
    CreatorUserTask creatorUserTask;
    @Autowired
    BuilderAnswersList builderAnswersList;

    @Autowired
    BuilderAnswer builderAnswer;

    @Autowired
    BuilderSource builderSource;


    @RequestMapping("/create/{source}/{id_source}/")
    public String createUserTask(@PathVariable String token, @PathVariable String source,@PathVariable int id_source) {
        //TODO


        creatorUserTask.create(
                builderUser.getUser(
                        builderToken.getToken(token)),
                builderTask.get(
                        builderSource.get(source,id_source)));

        //получить юзера
        // найти таску по слову и источнику
        // создаю юзер таску
        // вернуть ок
        log.info(source+" "+id_source);
        return "ok";
    }

    @RequestMapping("/create/all/")
    public String createUserTaskAll(@PathVariable String token) {
        //TODO

        creatorUserTask.create(
                builderUser.getUser(
                        builderToken.getToken(token)),

                builderTask.get(builderSource.get(TypeSource.word)));

        //получить юзера
        // найти таску по слову и источнику
        // создаю юзер таску
        // вернуть ок
        log.info("all");
        return "ok";
    }


    @RequestMapping("/get/next/")
    public UserTaskDTO getNextUserTask(@PathVariable String token) {
        //проверить токен
        UserTask userTask = builderUserTask.getNext(
                builderUser.getUser(
                        builderToken.getToken(token)));

//TODO
        UserTaskDTO userTaskDTO = new UserTaskDTO(userTask,
                builderAnswersList.get(userTask.getTask().getTrueAnswer()),
                builderAnswer.get(userTask.getTask().getTrueAnswer()).getValue());
        log.info("дернули");


        return userTaskDTO;
    }

    @RequestMapping("/get/{id_user_task}/")
    public String getUserTask(@PathVariable String token) {

        return "доделай метод UserTaskForWeb";

    }

}
