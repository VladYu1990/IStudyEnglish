package ru.project.IStudyEnglish.like_is_module.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.learning_module.service.BuilderAnswer;
import ru.project.IStudyEnglish.like_is_module.service.CreatorOfSimilarAnswers;

@RestController
@RequestMapping("/v1/{token}/simular_answers/")
@Log4j2
public class SimilarAnswersController {



    @Autowired
    CreatorOfSimilarAnswers creatorOfSimilarAnswers;

    @Autowired
    BuilderAnswer builderAnswer;



    @RequestMapping("/create/{id}")
    public String create(@PathVariable String token,  @PathVariable int id){
        //TODO

        creatorOfSimilarAnswers.create(builderAnswer.get(id));

        return "ok";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable String token, @PathVariable int source_str){
        //TODO

        return "ok";
    }

    @RequestMapping("/selete/{id}")
    public String delete(@PathVariable String token, @PathVariable int source_str){
        //TODO

        return "ok";
    }

}
