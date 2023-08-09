package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.user_module.entity.User.User;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;
import ru.project.IStudyEnglish.learning_module.repository.UserTask.SourceUserTask;
import ru.project.IStudyEnglish.learning_module.repository.UserTask.UserTaskDAO;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreatorUserTask {

    public BuilderTask builderTask;

    public SourceUserTask sourceUserTask = new UserTaskDAO();

    private List<UserTask> userTasksList = new ArrayList<>();


    @Autowired
    public CreatorUserTask(BuilderTask builderTask, SourceUserTask sourceUserTask) {
        this.builderTask = builderTask;
        this.sourceUserTask = sourceUserTask;
    }


    public void create(User user, Task task) {
        this.userTasksList.clear();
        cre(user,task);
        sourceUserTask.save(this.userTasksList);
    }


    public void create(User user, List<Task> list) {
        this.userTasksList.clear();
        for (int i = 0; i < list.size(); i++) {
            cre(user, list.get(i));
        }
        sourceUserTask.save(this.userTasksList);
    }


    private void cre(User user, Task task) {

        userTasksList.add(new UserTask(user,task));
    }

    private void save(List<UserTask> userTaskList){
        sourceUserTask.save(userTaskList);
    }
}

