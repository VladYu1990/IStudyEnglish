package ru.project.IStudyEnglish.controllers.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.domen.CreatorTaskForRepetition;
import ru.project.IStudyEnglish.domen.CreatorUserTask;

import java.util.Objects;

//класс для работы с фронтом
@RestController
@RequestMapping("/v1/creator/{token}/")
public class CreatorController  {

    @RequestMapping("/creator_task_for_repetition")
    public String startCreatorTaskForRepetition(@PathVariable String token) {
        if(Objects.equals(token, "123")) {
            CreatorTaskForRepetition.start();
            return "готово";
        }
        else {
            return "токен не верный";
        }

    }
    @RequestMapping("/creator_user_task/{userToken}")
    public String startCreatorUserTask(@PathVariable String token,@PathVariable String userToken) {
        if(Objects.equals(token, "123")){
            CreatorUserTask.start(userToken);
        return "готово";
        }
        else {
        return "токен не верный";
        }
    }
}


