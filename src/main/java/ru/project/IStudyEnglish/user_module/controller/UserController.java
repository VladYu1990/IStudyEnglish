package ru.project.IStudyEnglish.user_module.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.user_module.service.Token.BuilderToken;
import ru.project.IStudyEnglish.user_module.service.Token.CreatorToken;
import ru.project.IStudyEnglish.user_module.service.User.BuilderUser;
import ru.project.IStudyEnglish.user_module.service.User.CreatorUser;
import ru.project.IStudyEnglish.user_module.entity.User.Token;
import ru.project.IStudyEnglish.user_module.entity.User.User;

import java.io.IOException;

@RestController
@RequestMapping("/v1/user/")
@Log4j2
@Scope("prototype")
public class UserController {

    @Autowired
    CreatorToken creatorToken;

    @Autowired
    BuilderToken builderToken;
    @Autowired
    CreatorUser creatorUser;
    @Autowired
    BuilderUser builderUser;


    @RequestMapping("/create/{login}/{password}")
    public String createUser(@PathVariable String login, @PathVariable String password) {
        creatorUser.create(login,password);
        User user =  builderUser.getUser(login,password);
        creatorToken.create(user);
        try {
            return builderToken.get(user).getTokenStr();
        }
        catch (IOException e){
            log.info(e);
            return "error";
        }
    }
    @RequestMapping("/get_token/{login}/{password}")
    public String GetToken(@PathVariable String login, @PathVariable String password)  {
        User user = new User();
        Token token = new Token();
        try {
        user = builderUser.getUser(login, password);
         }
        catch (Exception e){
            return "пользователь не найден";
        }
        try {
            token = builderToken.get(user);
        }
        catch (Exception e) {
            creatorToken.create(user);
        }
        try {
            token = builderToken.get(user);
        }
        catch (Exception e) {
            return "404";
        }

        return token.getTokenStr();
    }
}
