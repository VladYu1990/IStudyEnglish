package ru.project.IStudyEnglish.learning_module.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/{token}/tasks/")
@Log4j2
public class TaskController {

    @Autowired
    public ControllerHandler controllerHandler;

    @RequestMapping("/create/{source_str}/{id_source}")
    public String create(@PathVariable String token,@PathVariable String source_str,@PathVariable int id_source){
        log.info("run");
        controllerHandler.taskCreate(token,source_str,id_source);

        return "ok";

    }

    @RequestMapping("/create_all/{source_str}")
    public String create(@PathVariable String token,@PathVariable String source_str) {

        controllerHandler.taskCreate(token,source_str);
        return "ok";
    }

    @RequestMapping("/create_all/")
    public String create(@PathVariable String token) {

        controllerHandler.taskCreate(token);
        return "ok";
    }
}