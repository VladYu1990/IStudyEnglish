package ru.project.IStudyEnglish.controllers.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.controllers.Validators.Validator;
import ru.project.IStudyEnglish.controllers.Validators.ValidatorEnum;
import ru.project.IStudyEnglish.controllers.Validators.ValidatorFactory;
import ru.project.IStudyEnglish.domen.Choicers.ChoicerUserTask;
import ru.project.IStudyEnglish.domen.DTO.User;
import ru.project.IStudyEnglish.domen.DTO.Task.UserTask.UserTask;

//класс для работы с фронтом
@RestController
@RequestMapping("/v1/new_topic/{token}/")
@Log4j2
public class NextTopicController {

    @RequestMapping("/")
    public Object greetingNextTopic(@PathVariable String token) {
        Validator validator = ValidatorFactory.createValidator(ValidatorEnum.token);//валидация токена, через фабрику валидаций
        if(Validator.validation(token)==true){

        }
        else{

        }
        User user = new User();
        String userId = user.getIdUser(token);

        String idNextTask = ChoicerUserTask.getNext(userId);//выбор следующего задания, чойзер, получить id
        UserTask task = new UserTask(idNextTask);
        //генерация следующего задания по id
        task.updateStatus();
        return task;
    }
}

