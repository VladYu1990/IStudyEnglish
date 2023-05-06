package ru.project.IStudyEnglish.controllers.Validators;

public class ValidatorToken implements Validator{


    public ValidatorToken() {
    }

    public void validation(String objectForValidation) throws Exception {
        if (objectForValidation.equals("123")) {
            //TODO тут будем ходить в БД и искать токен
            // а пока хардкод))

        } else {
            throw new Exception("user with " + objectForValidation + " token didn't find");
        }
    }
}
