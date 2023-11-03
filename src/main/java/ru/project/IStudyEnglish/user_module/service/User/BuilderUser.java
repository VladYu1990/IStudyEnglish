package ru.project.IStudyEnglish.user_module.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.user_module.entity.User.Token;
import ru.project.IStudyEnglish.user_module.entity.User.User;

@Component
public class BuilderUser {
    private User user;
    private String login;
    private String password;
    UserDAO userDAO;

    @Autowired
    public BuilderUser(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getUser(String login, String password){

        return this.userDAO.getUser(login,password);
    }

    public User getUser(Token token){
        return userDAO.getUser(token.getIdUser());
    }

    public User getUser(String login){
        return userDAO.getUser(login);
    }
    public User getUser(int id){
        return userDAO.getUser(id);
    }

    public boolean notExist(String login){
        if(getUser(login) == null){
            return true;
        }
        else {
            return false;
        }
    }

}
