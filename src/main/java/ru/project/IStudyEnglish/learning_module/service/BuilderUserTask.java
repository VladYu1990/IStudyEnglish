package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.learning_module.entity.User.User;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;
import ru.project.IStudyEnglish.learning_module.repository.UserTask.SourceUserTask;

@Component
public class BuilderUserTask {
//инкапсулирует в себе разные способы создания UserTaskController
    // могут отличаться по источнику данных и по типу запроса id, next

    private SourceUserTask sourceUserTask;//как источник данных для UserTaskController

    public BuilderUserTask() {
    }


    @Autowired
    public BuilderUserTask(SourceUserTask sourceUserTask) {
        this.sourceUserTask = sourceUserTask;
    }

    public UserTask createUserTask(User user, Task task){
        UserTask userTask = new UserTask(user,task);
        return userTask;
    }

    public UserTask getOnId(int id) {
        return sourceUserTask.getOnId(id);
    }

    public UserTask getNext(User user) {
        return sourceUserTask.getNext(user);
    }
}
