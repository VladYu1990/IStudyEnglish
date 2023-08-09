package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.User.User;
import ru.project.IStudyEnglish.learning_module.repository.User.UserDAO;

@Component
public class CreatorUser {

    UserDAO userDAO;
    BuilderToken builderToken;
    CreatorToken creatorToken;

    @Autowired



    public User create(String login,String password){
        User user = new User(0, login, password);
        this.userDAO.save(user);
        return user;
    }




}
