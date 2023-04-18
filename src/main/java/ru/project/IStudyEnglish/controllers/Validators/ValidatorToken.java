package ru.project.IStudyEnglish.controllers.Validators;

public class ValidatorToken implements Validator{


    public ValidatorToken() {
    }

    public boolean validation(String objectForValidation) {
        if(objectForValidation.equals("123")){
        //тут будем ходить в БД и искать токен
            return true;
        }
        else {
            return false;
        }
    }

}
