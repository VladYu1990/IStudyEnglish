package ru.project.IStudyEnglish.controllers.Validators;

public class ValidationContext {
    private Validator validator;

    public ValidationContext(){

    }

    public void setValidator(Validator validator){
        this.validator = validator;

    }

    public void validation(String string) throws Exception {
        validator.validation(string);
    }

}
