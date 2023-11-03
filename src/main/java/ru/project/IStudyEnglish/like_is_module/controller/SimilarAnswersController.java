package ru.project.IStudyEnglish.like_is_module.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.like_is_module.service.CreatorOfSimilarAnswers;

@RestController
@RequestMapping("/v1/{token}/simular_answers/")
@Log4j2
public class SimilarAnswersController {



    @Autowired
    CreatorOfSimilarAnswers creatorOfSimilarAnswers;


    @RequestMapping("/create/{id}")
    public String create(@PathVariable String token,  @PathVariable int id){
        //TODO for token
        creatorOfSimilarAnswers.create(id);

        return "ok";
    }

    @RequestMapping("/create_all")
    public String create(@PathVariable String token){
        //TODO for token
        creatorOfSimilarAnswers.create();

        return "ok";
    }


}
