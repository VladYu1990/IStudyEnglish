package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.user_module.entity.User.Token;
import ru.project.IStudyEnglish.user_module.entity.User.User;
import ru.project.IStudyEnglish.learning_module.repository.User.TokenDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuilderToken {

    public TokenDAO tokenDAO;


    @Autowired
    public BuilderToken(TokenDAO tokenDAO) {
        this.tokenDAO = tokenDAO;
    }


    public Token getToken(String tokenStr){
        return this.tokenDAO.getToken(tokenStr);
    }

    public List<Token> getToken(ArrayList<String> tokenStrList){

        return this.tokenDAO.getToken(tokenStrList);
    }

    public Token getToken(User user) throws IOException {
        return tokenDAO.getToken(user.getId());
    }
}
