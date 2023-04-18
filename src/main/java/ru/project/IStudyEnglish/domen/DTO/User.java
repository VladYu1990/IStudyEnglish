package ru.project.IStudyEnglish.domen.DTO;

import java.sql.Time;

public class User {
    String id;
    String token;
    String login;
    String password;
    Time blokedBeforeToThisTime;


    public User(){
        //источником из БД, через ДАО
    }

    public User getUser(int code) {
        User user = new User(); // заменить на запрос юзера из БД c проверкой логин пароля
        return user;
    }

    public String getIdUser(String token) {
         // идем в бд и ищем юзера по токену
        return this.id;
    }

    public String getNewToken(String login, String password){
        String token = null;
        //идем в бд, ищем юзера, если находим, генерим токен
        //сохраняем токен в БД
        return token;
    }
    public void validationToken(String token){
        token = "18";
         //возможно, это отдельный объект валидатор
    }
    public void getNewPassword(String login){
        //генерим новый код
        //шлем код в смс/ватсап
        //сохраняем код в БД, если отправка была успешной
    }


}
