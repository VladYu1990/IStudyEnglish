package ru.project.IStudyEnglish.learning_module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.user_module.service.Token.BuilderToken;
import ru.project.IStudyEnglish.user_module.service.User.BuilderUser;
import ru.project.IStudyEnglish.user_module.entity.User.Token;
import ru.project.IStudyEnglish.user_module.entity.User.User;

@Component
public class GetUser {

    BuilderToken builderToken;
    BuilderUser builderUser;

    public GetUser() {
    }

    @Autowired
    public GetUser(BuilderToken builderToken, BuilderUser builderUser) {
        this.builderToken = builderToken;
        this.builderUser = builderUser;
    }

    public User getByToken(String tokenStr){
        Token token = builderToken.get(tokenStr);
        User user = builderUser.getUser(token);

        return  user;

    }
}
