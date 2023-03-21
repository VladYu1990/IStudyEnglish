package ru.project.IStudyEnglish.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.DTO.Word;
import ru.project.IStudyEnglish.infrastructure.ConnectDB;

import java.sql.SQLException;


@RestController
@RequestMapping("/word/")
public class WordController {

    @RequestMapping("/get")
    public Word greeting() throws SQLException {
        Word word = new Word();
        System.out.println("запрос исполнен");
        ConnectDB connectDB = new ConnectDB();
        connectDB.connectionDB();
        return word;
    }
}
