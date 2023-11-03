package ru.project.IStudyEnglish.user_module.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.learning_module.service.BuilderUser;
import ru.project.IStudyEnglish.learning_module.service.BuilderToken;
import ru.project.IStudyEnglish.learning_module.service.CreatorUser;

import java.io.IOException;

@RestController
@RequestMapping("/v1/users/")
@Log4j2
public class UserController2 {

    @Autowired
    BuilderUser builderUser;
    @Autowired
    CreatorUser creatorUser;
    @Autowired
    BuilderToken builderToken;


    @RequestMapping("/create/{login}/{password}")
    public String create(@PathVariable String login, @PathVariable String password) {

        if(builderUser.notExist(login) == true) {
            creatorUser.create(login, password);

            return "пользователь с логином " + login + " и паролем " + password + " создан";
        }
        else {
            new Exception("уже существует");
            return "пользователь с логином " + login + " уже существует";
        }

    }

    @RequestMapping("/authorization/{login}/{password}")
    public Object authorization(@PathVariable String login, @PathVariable String password) {

        try {
            return builderToken.get(builderUser.getUser(login,password));
        }
        catch (IOException e){
            return "не верный логин и пароль";
        }
    }

    @RequestMapping("/get_new_password/{login}/")
    public String authorization(@PathVariable String login) {
//TODO
        return "password in telegram";
    }
}
