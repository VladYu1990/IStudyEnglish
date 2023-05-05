package ru.project.IStudyEnglish.controllers.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.controllers.Validators.ValidationContext;
import ru.project.IStudyEnglish.controllers.Validators.ValidatorToken;
import ru.project.IStudyEnglish.domen.DTO.Task.UserTask;
import ru.project.IStudyEnglish.domen.DTO.User;

@RestController
@RequestMapping("/v1/next_user_task/{token}/")
@Log4j2
public class NextTaskController {

    @RequestMapping("/")
    public Object greetingNextTopic(@PathVariable String token){
        try {

            ValidationContext validationContext = new ValidationContext();
            validationContext.setValidator(new ValidatorToken());
            validationContext.validation(token);
            //TODO сделать и проверить получение юзера
            User user = new User();
            user.fillViaToken(token);
            UserTask userTask = new UserTask();
            userTask.fillNext(user.getId());

            return userTask;
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }
}

