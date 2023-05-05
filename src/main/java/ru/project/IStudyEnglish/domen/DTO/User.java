package ru.project.IStudyEnglish.domen.DTO;

import ru.project.IStudyEnglish.infrastructure.DAO.UserDAO;
import ru.project.IStudyEnglish.infrastructure.repository.SourceUser;

import java.sql.Timestamp;

public class User {
    private String id="1";
    private String token;
    private String timeLifeToken;
    private String login;
    private String password;
    private Timestamp blockedBeforeToThisTime;
    private SourceUser data = new UserDAO();


    public User(){
        //источником из БД, через ДАО
    }

    public String getId() {

        return this.id;
    }

    public void fillViaToken(String token){
        //TODO идем в бд и ищем юзера по токену
        //идем в бд, ищем юзера, через токен
        //заполняем юзера
    }
    public void fillViaId(String id){
        //идем в бд, ищем юзера, через токен
        //заполняем юзера
    }
    public void fillViaLogin(String login){
        //идем в бд, ищем юзера, через токен
        //заполняем юзера
    }


    public void setNewToken(String login, String password){
        this.token = null;
        //идем в бд, ищем юзера, если находим, генерим токен
        //сохраняем токен в БД
    }


    private void setNewPassword(String login){
        //генерим новый код
        //шлем код в смс/ватсап
        //сохраняем код в БД, если отправка была успешной
    }


}
