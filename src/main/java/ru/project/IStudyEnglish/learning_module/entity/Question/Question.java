package ru.project.IStudyEnglish.learning_module.entity.Question;

import org.springframework.stereotype.Component;

@Component
public class Question {
    private int id;
    private String value;
    //TODO убрать заглушку



    public Question(){
        this.id = 15;
        this.value = "тестовый вопрос";

    }

    public Question(int id){
        //TODO убрать заглушку
        this.id = 15;
        this.value = "тестовый вопрос:где?";
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}