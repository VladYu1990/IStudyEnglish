package ru.project.IStudyEnglish.learning_module.repository.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.service.User.BuilderUser;
import ru.project.IStudyEnglish.user_module.entity.User.User;
import ru.project.IStudyEnglish.learning_module.service.User.CreatorUser;

@Component
public class DirectorUser {

    CreatorUser creatorUser;
    BuilderUser builderUser;

    @Autowired

    public User create(){

        return null;
    }

    public User get(){

        return null;
    }



}
