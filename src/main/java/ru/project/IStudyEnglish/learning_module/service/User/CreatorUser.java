package ru.project.IStudyEnglish.learning_module.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.service.CreatorToken;
import ru.project.IStudyEnglish.learning_module.service.User.BuilderUser;
import ru.project.IStudyEnglish.user_module.entity.User.User;
import ru.project.IStudyEnglish.learning_module.repository.User.UserDAO;

@Component
public class CreatorUser {

    UserDAO userDAO;
    CreatorToken creatorToken;
    BuilderUser builderUser;

    @Autowired

    public CreatorUser(UserDAO userDAO, CreatorToken creatorToken, BuilderUser builderUser) {
        this.userDAO = userDAO;
        this.creatorToken = creatorToken;
        this.builderUser = builderUser;
    }

    public User create(String login, String password){
        User user = new User(0, login, password);
        this.userDAO.save(user);

        user = builderUser.getUser(login,password);
        creatorToken.create(user);
        return user;
    }




}
