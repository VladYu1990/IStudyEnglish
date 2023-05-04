package ru.project.IStudyEnglish.controllers.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//класс для работы с фронтом
@RestController
@RequestMapping("/v1/return_answer/{token}/{id_user_task}/{true_answer}")
@Log4j2
public class ReturnAnswerOnTaskController {

    @RequestMapping("/")
    public String greetingNextTopic(@PathVariable String token,
                                    @PathVariable String id_user_task,
                                    @PathVariable String true_answer) {
        return "ok";
    }
}


