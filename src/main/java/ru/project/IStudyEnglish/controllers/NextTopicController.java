package ru.project.IStudyEnglish.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.DAO.WordDAO;
import ru.project.IStudyEnglish.DTO.RepetitionExercise;

//класс для работы с фронтом
@RestController
@RequestMapping("/NewTopic/")
public class NextTopicController {

    @RequestMapping("/{id}")
    public WordDAO greeting(@PathVariable int id) {
        RepetitionExercise repetitionExercise
                = new RepetitionExercise();
        System.out.println("запрос исполнен");

        WordDAO wordDAO = WordDAO.getWordDAO(id);

        return wordDAO;
    }

    @RequestMapping
    public WordDAO greeting() {
        RepetitionExercise repetitionExercise
                = new RepetitionExercise();
        System.out.println("запрос исполнен");

        WordDAO wordDAO = WordDAO.getNextWordDAO();

        return wordDAO;
    }
}
