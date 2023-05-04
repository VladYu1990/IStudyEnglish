package ru.project.IStudyEnglish.controllers.Validators;


public class ValidatorFactory {



    public static Validator createValidator(ValidatorEnum typeValidation){
        Validator validator = null;
        switch (typeValidation) {
            case token:
                validator = new ValidatorToken();
                break;
            case test:
                //validator = new ValidatorTypeTask();
                break;
            default:
                new String("ошибка2");
        }
        return validator;

    }
}
