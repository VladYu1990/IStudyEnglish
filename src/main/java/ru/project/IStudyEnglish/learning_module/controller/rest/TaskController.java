package ru.project.IStudyEnglish.learning_module.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.learning_module.service.BuilderTask;
import ru.project.IStudyEnglish.learning_module.service.CreatorTask;

@RestController
@RequestMapping("/v1/{token}/tasks/")
@Log4j2
@Scope("prototype")
public class TaskController {

    @Autowired
    private BuilderTask builderTask;
    @Autowired
    private CreatorTask creatorTask;

    @RequestMapping("/create/{source}/{id_source}")
    public String create(@PathVariable String source,@PathVariable int idSource){



        return "ok";

    }

    @RequestMapping("/for_all_new_words/create/")
    public String create(){

        return "count created";

    }
}
