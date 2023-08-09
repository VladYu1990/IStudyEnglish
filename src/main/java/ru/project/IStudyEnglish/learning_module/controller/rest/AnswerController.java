package ru.project.IStudyEnglish.learning_module.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.dictionary_module.service.BuilderSource;
import ru.project.IStudyEnglish.learning_module.service.BuilderAnswer;
import ru.project.IStudyEnglish.learning_module.service.CreatorAnswer;

@RestController
@RequestMapping("/v1/{token}/answer/")
@Log4j2
public class AnswerController {

    @Autowired
    BuilderAnswer builderAnswer;

    @Autowired
    CreatorAnswer creatorAnswer;

    @Autowired
    BuilderSource builderSource;



    @RequestMapping("/create/{source_str}/{id_source}")
    public String create(@PathVariable String token, @PathVariable String source_str, @PathVariable int id_source){
        //TODO
        log.info("run /create/{source_str}/{id_source}");
        creatorAnswer.create(builderSource.get(source_str,id_source));
        return "ok";
    }

    @RequestMapping("/create/all_new")
    public String create(@PathVariable String token){

        creatorAnswer.create(builderSource.get());
        //TODO
        return "todo it";
    }

    @RequestMapping("/update/{id}/{values}/{type_answer}")
    public String update(@PathVariable String token,@PathVariable int id){
        //TODO
        return "todo it";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String token,@PathVariable int id){
        //TODO
        return "todo it";
    }


}
