package ru.project.IStudyEnglish.infrastructure.repository;


import org.springframework.stereotype.Component;

@Component
public class StringSQL {
    String stringSQL;

    public StringSQL(){}

    public StringSQL(String stringSQL){
        this.stringSQL = stringSQL;
    }

    public String getStringSQL(){
        return this.stringSQL;
    }
}
