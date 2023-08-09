package ru.project.IStudyEnglish.dictionary_module.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.dictionary_module.entity.PartOfSpeech;
import ru.project.IStudyEnglish.dictionary_module.service.CreatorWord;

@RestController
@RequestMapping("/v1/{token}/words/")
@Log4j2

public class WordController {

    @Autowired
    CreatorWord creatorWord;

    @RequestMapping("/create/{rusText}/{engText}/{partOfSpeech}")
    public String create(@PathVariable String token,@PathVariable String rusText,@PathVariable String engText,@PathVariable String partOfSpeech) {
       if (token.equals("123123")){
           creatorWord.create(rusText,engText, PartOfSpeech.valueOf(partOfSpeech));
           return "ok";
       }

       else {
           return "not";
       }

    }


}
