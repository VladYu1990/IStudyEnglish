package ru.project.IStudyEnglish.repository;

import java.sql.Time;

public class User {
    int id;
    String name;
    String token;
    String login;
    String password;
    Time blokedBeforeThisTime;
    //ArrayList<int> typeTopicTOP;

    public User getUser(int code) {
        User user = new User(); // заменить на запрос юзера из БД c проверкой логин пароля
        return user;
    }


}
