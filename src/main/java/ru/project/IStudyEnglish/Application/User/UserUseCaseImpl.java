package ru.project.IStudyEnglish.Application.User;

import org.springframework.stereotype.Service;
import ru.project.IStudyEnglish.domain.Autorisation.User;
import ru.project.IStudyEnglish.port.in.User.UserUseCase;

import java.time.Instant;

@Service
public class UserUseCaseImpl implements UserUseCase {
    @Override
    public void create(String login, String password, Instant instant) {

    }

    @Override
    public String logIn(String login, String password) {
        return null;
    }

    @Override
    public User get(String token) {
        return null;
    }


}
