package ru.project.IStudyEnglish.controllers.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.controllers.Validators.ValidationContext;
import ru.project.IStudyEnglish.controllers.Validators.ValidatorToken;
import ru.project.IStudyEnglish.domen.DTO.Task.UserTask;
import ru.project.IStudyEnglish.domen.DTO.User;

@Log4j2
@RestController
@RequestMapping("/v1/return_answer")
public class ReturnAnswerOnTaskController {

    @RequestMapping("/{token}/{id_user_task}/{correct_answer}")
    public void return_answer(@PathVariable String token,
                                    @PathVariable int id_user_task,
                                    @PathVariable boolean correct_answer){
        try {
                ValidationContext validationContext = new ValidationContext();
                validationContext.setValidator(new ValidatorToken());
                //TODO разобраться с SQL инекцией через токен
                validationContext.validation(token);

                User user = new User();
                //TODO разобраться с SQL инекцией через токен
                user.fillViaToken(token);

                UserTask userTask = new UserTask();
                userTask.fillById(id_user_task);
                userTask.update(Boolean.valueOf(correct_answer));
            }
        catch (Exception ex){
        }
    }
}


