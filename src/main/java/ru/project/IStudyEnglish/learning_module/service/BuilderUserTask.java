package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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


    public UserTask get(int id) {
        return sourceUserTask.getOnId(id);
    }

}
