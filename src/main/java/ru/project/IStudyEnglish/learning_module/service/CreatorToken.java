package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.user_module.entity.User.Token;
import ru.project.IStudyEnglish.user_module.entity.User.User;
import ru.project.IStudyEnglish.learning_module.repository.User.TokenDAO;

@Component
public class CreatorToken {

    TokenDAO tokenDAO;
    Token token;

    @Autowired
    public CreatorToken(TokenDAO tokenDAO) {
        this.tokenDAO = tokenDAO;
    }

    public void create(User user){
        this.token = new Token(user);
        tokenDAO.save(this.token);
    }
}
