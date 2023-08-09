package ru.project.IStudyEnglish.learning_module.entity.User;

import org.apache.commons.lang3.RandomStringUtils;

import java.sql.Timestamp;

public class Token {

    int idUser;
    String tokenStr;
    Timestamp dateCreated;
    Timestamp dateDie;


    public Token() {
        Long timeLifeToken = Long.valueOf(30*24*60*60*1000); //30 days
        this.generateTokenStr();
        this.dateCreated = new Timestamp(System.currentTimeMillis());
        this.dateDie = new Timestamp(System.currentTimeMillis() + timeLifeToken);
    }

    public Token(String tokenStr) {
        this.tokenStr = tokenStr;
    }

    public Token(String tokenStr, Timestamp dateCreated, Timestamp dateDie) {
        this.tokenStr = tokenStr;
        this.dateCreated = dateCreated;
        this.dateDie = dateDie;
    }

    private void generateTokenStr(){
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        this.tokenStr = RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public String getTokenStr() {
        return tokenStr;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDateDie() {
        return dateDie;
    }

    public void setDateDie(Timestamp dateDie) {
        this.dateDie = dateDie;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
