package ru.project.IStudyEnglish.domen.DTO.SourceObject;


import org.springframework.stereotype.Component;

@Component
public class Rule extends ObjectSource {
    private int id;
    private String value;

    public Rule(){
        this.id = 1;
        this.value = "a test rule";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
