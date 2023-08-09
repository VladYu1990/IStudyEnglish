package ru.project.IStudyEnglish.learning_module.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.dictionary_module.service.BuilderSource;
import ru.project.IStudyEnglish.learning_module.entity.TypeSource;
import ru.project.IStudyEnglish.learning_module.service.BuilderTask;
import ru.project.IStudyEnglish.learning_module.service.CreatorTask;

@RestController
@RequestMapping("/v1/{token}/tasks/")
@Log4j2
public class TaskController {

    @Autowired
    private BuilderTask builderTask;
    @Autowired
    private CreatorTask creatorTask;
    @Autowired
    private BuilderSource builderSource;

    @RequestMapping("/create/{source_str}/{id_source}")
    public String create(@PathVariable String token,@PathVariable String source_str,@PathVariable int id_source){
        log.info("run");

        creatorTask.create(builderSource.get(source_str,id_source));

        return "ok";

    }

    @RequestMapping("/create_all/{source_str}")
    public String create(@PathVariable String token,@PathVariable String source_str) {

        creatorTask.create(builderSource.get(TypeSource.word));
        return "ok";
    }
}
