package ru.project.IStudyEnglish.user_module.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.user_module.service.Token.CreatorToken;
import ru.project.IStudyEnglish.user_module.entity.User.User;

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

    public void create(String login, String password){
        User user = new User(0, login, password);
        this.userDAO.save(user);

        user = builderUser.getUser(login,password);
        creatorToken.create(user);
    }




}
