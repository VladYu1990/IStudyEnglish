package ru.project.IStudyEnglish.learning_module.repository.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.service.BuilderUser;
import ru.project.IStudyEnglish.learning_module.entity.User.User;
import ru.project.IStudyEnglish.learning_module.service.CreatorUser;

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
