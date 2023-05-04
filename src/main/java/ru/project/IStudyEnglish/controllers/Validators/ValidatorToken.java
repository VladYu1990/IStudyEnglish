package ru.project.IStudyEnglish.controllers.Validators;

public class ValidatorToken implements Validator{


    public ValidatorToken() {
    }

    public void validation(String objectForValidation) throws Exception {
        if (objectForValidation.equals("123")) {
            //тут будем ходить в БД и искать токен

        } else {
            throw new Exception("user with " + objectForValidation + " token didn't find");
        }
    }
}
