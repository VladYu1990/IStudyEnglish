package ru.project.IStudyEnglish.like_it_module.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.like_it_module.service.CreatorSimilarAnswers;

@RestController
@RequestMapping("/v1/{token}/simular_answers/")
@Log4j2
public class SimilarAnswersController {



    @Autowired
    CreatorSimilarAnswers creatorSimilarAnswers;


    @RequestMapping("/create/{id}")
    public String create(@PathVariable String token,  @PathVariable int id){
        //TODO for token
        creatorSimilarAnswers.create(id);

        return "ok";
    }

    @RequestMapping("/create_all")
    public String create(@PathVariable String token){
        //TODO for token
        creatorSimilarAnswers.create();

        return "ok";
    }


}
