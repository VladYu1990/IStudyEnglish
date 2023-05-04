package ru.project.IStudyEnglish.controllers.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/return_answer/{token}/{id_user_task}/{true_answer}")
public class ReturnAnswerOnTaskController {

    @RequestMapping("/")
    public String greetingNextTopic(@PathVariable String token,
                                    @PathVariable String id_user_task,
                                    @PathVariable String true_answer) {
        return "ok";
    }
}


