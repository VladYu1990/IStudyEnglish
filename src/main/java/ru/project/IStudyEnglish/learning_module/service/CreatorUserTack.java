package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.beans.factory.annotation.Autowired;

public class CreatorUserTack {

    BuilderUserTask builderUserTask;

    @Autowired
    public CreatorUserTack(BuilderUserTask builderUserTask) {
        this.builderUserTask = builderUserTask;
    }


}
