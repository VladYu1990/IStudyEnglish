package ru.project.IStudyEnglish.controllers.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserTask userTask;

    @RequestMapping("/")
    public UserTask greetingNextTopic(@PathVariable String token){


            //TODO  нужен еще слой где будет логика, чтоб ее можно было переиспользовать
            ValidationContext validationContext = new ValidationContext();
            validationContext.setValidator(new ValidatorToken());
            //TODO разобраться с SQL инекцией через токен
            //validationContext.validation(token);

            User user = new User();
            user.fillViaToken(token);

            //UserTask userTask = new UserTask();
            this.userTask.fillNext(user.getId());

            return this.userTask;

    }
}

