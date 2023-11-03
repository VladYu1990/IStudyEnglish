package ru.project.IStudyEnglish.user_module.service.Token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.user_module.entity.User.Token;
import ru.project.IStudyEnglish.user_module.entity.User.User;

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
