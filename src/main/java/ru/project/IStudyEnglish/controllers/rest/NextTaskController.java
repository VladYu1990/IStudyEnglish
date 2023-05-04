package ru.project.IStudyEnglish.controllers.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.controllers.Validators.ValidationContext;
import ru.project.IStudyEnglish.controllers.Validators.ValidatorToken;
import ru.project.IStudyEnglish.domen.DTO.Task.UserTask.UserTask;
import ru.project.IStudyEnglish.domen.DTO.User;

@RestController
@RequestMapping("/v1/next_user_task/{token}/")
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

            return new UserTask().fillNext(user.getId());
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }
}

