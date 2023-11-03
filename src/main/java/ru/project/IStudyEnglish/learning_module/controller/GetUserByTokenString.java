package ru.project.IStudyEnglish.learning_module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.service.BuilderToken;
import ru.project.IStudyEnglish.learning_module.service.BuilderUser;
import ru.project.IStudyEnglish.user_module.entity.User.Token;
import ru.project.IStudyEnglish.user_module.entity.User.User;

@Component
public class GetUserByTokenString {

    BuilderToken builderToken;
    BuilderUser builderUser;

    public GetUserByTokenString() {
    }

    @Autowired
    public GetUserByTokenString(BuilderToken builderToken, BuilderUser builderUser) {
        this.builderToken = builderToken;
        this.builderUser = builderUser;
    }

    public User get(String tokenStr){
        Token token = builderToken.get(tokenStr);
        User user = builderUser.getUser(token);

        return  user;

    }
}
