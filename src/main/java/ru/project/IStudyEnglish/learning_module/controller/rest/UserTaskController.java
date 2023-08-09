package ru.project.IStudyEnglish.learning_module.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.learning_module.service.BuilderTask;
import ru.project.IStudyEnglish.learning_module.service.BuilderUser;
import ru.project.IStudyEnglish.learning_module.service.BuilderUserTask;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;
import ru.project.IStudyEnglish.learning_module.service.BuilderToken;
import ru.project.IStudyEnglish.learning_module.service.CreatorUserTask;

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


    @RequestMapping("/create/{source}/{id_source}")
    public String createUserTask(@PathVariable String tokenStr, @PathVariable String source,@PathVariable int idSource) {
        //TODO

        creatorUserTask.create(
                builderUser.getUser(
                        builderToken.getToken(tokenStr)),

                builderTask.get(source, Integer.parseInt(Integer.toString(idSource))));

        //получить юзера
        // найти таску по слову и источнику
        // создаю юзер таску
        // вернуть ок

        return "ok";
    }


    @RequestMapping("/get/next/")
    public UserTask getNextUserTask(@PathVariable String tokenStr) {
        //проверить токен
        return
                builderUserTask.getNext(
                    builderUser.getUser(
                        builderToken.getToken(tokenStr)));


    }

    @RequestMapping("/get/{id_user_task}/")
    public String getUserTask(@PathVariable String token) {

        return "доделай метод UserTaskForWeb";

    }

}
