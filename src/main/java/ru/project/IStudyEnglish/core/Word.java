package ru.project.IStudyEnglish.core;

import ru.project.IStudyEnglish.DTO.Answer;

public class Word extends Answer {
    private int id;
    private String value;
    //private String spelling;
    //private String partOfSpeech;
    //добавить тему слова - архитектура, погода, работа и тд

    public Word() {
        this.id = 1;
        this.value = "это слово2";

    }
    public Word(int id, String value) {
        this.id = id;
        this.value = value;

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }


    public String getValue(){
        return value;

    }
    public void setValue(String value){
        this.value=value;
    }


}
