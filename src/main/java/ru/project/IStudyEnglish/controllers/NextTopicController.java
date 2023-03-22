package ru.project.IStudyEnglish.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.DTO.TaskForRepetition;
import ru.project.IStudyEnglish.core.ChoicerNextTask;

import java.sql.SQLException;

//класс для работы с фронтом
@RestController
@RequestMapping("/v1/new-topic/")
public class NextTopicController {

    @RequestMapping("/{type-object}/{id}")
    public TaskForRepetition greetingId(@PathVariable int id) {

        System.out.println("запрос по id исполнен");

        return ChoicerNextTask.genNextTask();
    }

    @RequestMapping
    public Object greeting() throws SQLException {

        System.out.println("запрос следующего исполнен");

        return ChoicerNextTask.genNextTask();
    }
}
