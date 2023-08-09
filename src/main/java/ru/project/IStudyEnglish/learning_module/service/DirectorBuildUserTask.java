package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.User.User;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;

@Component
public class DirectorBuildUserTask {

    private BuilderUserTask builderUserTask;;


    @Autowired
    public DirectorBuildUserTask(BuilderUserTask builderUserTask){
        this.builderUserTask = builderUserTask;
    }

    public UserTask getOnId(int id){
        return builderUserTask.getOnId(id);
    }

    public UserTask getNextForUser(User user){
        return builderUserTask.getNext(user);
    }


}
