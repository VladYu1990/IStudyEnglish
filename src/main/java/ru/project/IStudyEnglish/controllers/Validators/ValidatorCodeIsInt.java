package ru.project.IStudyEnglish.controllers.Validators;

public class ValidatorCodeIsInt implements Validator{




    public static void validation(String objectForValidation, String strFromTextError) {
        try {
            Integer.valueOf("1");;
        } catch (Exception ex) {
            strFromTextError = "код должен быть целым числом";
        }
    }
}