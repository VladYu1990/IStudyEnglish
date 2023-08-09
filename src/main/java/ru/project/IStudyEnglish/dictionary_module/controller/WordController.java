package ru.project.IStudyEnglish.dictionary_module.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/{token}/words/")
@Log4j2

public class WordController {
    @RequestMapping("/create/{login}/{password}")
    public String create(@PathVariable int idWord) {

        return "ok";
    }
}
