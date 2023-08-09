package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Questions.Question;

@Component
public class DirectorBuilderQuestion {


    public Question getOnId(int id){
        //TODO

        return new Question(1);
    }
}
