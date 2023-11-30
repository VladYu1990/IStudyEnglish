package ru.project.IStudyEnglish.port.in.User;


import ru.project.IStudyEnglish.domain.Autorisation.User;

import java.time.Instant;

public interface UserUseCase {
    void create(String login, String password, Instant instant);
    String logIn(String login, String password);
    User get(String token);


}
