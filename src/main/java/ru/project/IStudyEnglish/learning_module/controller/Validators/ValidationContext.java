package ru.project.IStudyEnglish.learning_module.controller.Validators;

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
