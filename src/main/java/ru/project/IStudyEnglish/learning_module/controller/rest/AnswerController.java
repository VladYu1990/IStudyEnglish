package ru.project.IStudyEnglish.learning_module.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/{token}/answer/")
@Log4j2
public class AnswerController {

    public ControllerHandler controllerHandler;



    @RequestMapping("/create/{source_str}/{id_source}")
    public String create(@PathVariable String token, @PathVariable String source_str, @PathVariable int id_source){
        //TODO
        log.info("run /create/{source_str}/{id_source}");
        controllerHandler.answerCreate(token,source_str,id_source);
        return "ok";
    }

    @RequestMapping("/create/all_new")
    public String create(@PathVariable String token){

        controllerHandler.answerCreate();
        return "ok";
    }

}
