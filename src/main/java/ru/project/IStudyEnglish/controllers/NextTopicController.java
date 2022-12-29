package ru.project.IStudyEnglish.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.DAO.WordDAO;
import ru.project.IStudyEnglish.DTO.RepetitionExercise;
import ru.project.IStudyEnglish.DTO.TaskForRepetition;

//класс для работы с фронтом
@RestController
@RequestMapping("/NewTopic/")
public class NextTopicController {

    @RequestMapping("/{id}")
    public TaskForRepetition greeting(@PathVariable int id) {
        TaskForRepetition taskForRepetition = new TaskForRepetition();
        System.out.println("запрос по id исполнен");

        return taskForRepetition;
    }

    @RequestMapping
    public WordDAO greeting() {
        RepetitionExercise repetitionExercise
                = new RepetitionExercise();
        System.out.println("запрос следующего исполнен");

        WordDAO wordDAO = WordDAO.getNextWordDAO();

        return wordDAO;
    }
}
