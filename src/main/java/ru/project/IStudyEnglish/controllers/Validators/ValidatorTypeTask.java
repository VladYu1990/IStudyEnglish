package ru.project.IStudyEnglish.controllers.Validators;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.domen.DTO.Task.TaskType;


@Log4j2
public class ValidatorTypeTask{



    public static void validation(String objectForValidation, String strFromTextError) {

        try {
            TaskType.valueOf(objectForValidation);
        }
        catch (Exception ex){
            strFromTextError = "не известный тип объекта";
            log.error("ValidatorTypeTask doesn't ok");
        }
    }
}
