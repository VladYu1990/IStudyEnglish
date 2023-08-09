package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.learning_module.entity.User.User;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;
import ru.project.IStudyEnglish.learning_module.repository.UserTask.SourceUserTask;
import ru.project.IStudyEnglish.learning_module.repository.UserTask.UserTaskDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CreatorUserTask {

    public BuilderTask builderTask;

    public SourceUserTask sourceUserTask = new UserTaskDAO();


    @Autowired
    public CreatorUserTask(BuilderTask builderTask, SourceUserTask sourceUserTask) {
        this.builderTask = builderTask;
        this.sourceUserTask = sourceUserTask;
    }


    public void create(User user, Task task) {
        ArrayList<Task> listTask = null;
        listTask.add(task);
        create(user,listTask);
    }


    public void create(User user, List<Task> list) {
        List<UserTask> listUserTask = null;
        for (int i = 0; i < list.size(); i++) {
            listUserTask.addAll((
                    Collection<? extends UserTask>)
                            cre(user, list.get(i)));
        }
    }


    private UserTask cre(User user, Task task) {
        return new UserTask(user.getId(),task.getId());
    }

    private void save(List<UserTask> userTaskList){
        sourceUserTask.save(userTaskList);
    }
}

