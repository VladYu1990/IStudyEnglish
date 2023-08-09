package ru.project.IStudyEnglish.learning_module.controller.Validators;

import ru.project.IStudyEnglish.user_module.entity.User.Token;

import java.sql.Timestamp;

public class ValidatorToken{

    public static void validationNoSQLInjection(String strFromValidation) throws Exception {
        if (strFromValidation.length() == 10) {
        } else {
            throw new Exception("token:" + strFromValidation + " doesn't valid length");
        }
    }

    public static void validation(Token token) throws Exception{
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (token.getDateCreated().compareTo(now)<0 || token.getDateDie().compareTo(now) > 0){

        }
        else {
            throw new Exception("token:" + token.getTokenStr() + "doesn't valid create date or die date");
        }
    }
}
