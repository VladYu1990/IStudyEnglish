package ru.project.IStudyEnglish.learning_module.service.UserTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.learning_module.service.Task.BuilderTask;
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

    private List<Task> tasksList = new ArrayList<>();

    private User user;




    @Autowired
    public CreatorUserTask(BuilderTask builderTask, SourceUserTask sourceUserTask) {
        this.builderTask = builderTask;
        this.sourceUserTask = sourceUserTask;
    }


    public void create(User user, Task task) {
        clear();
        this.user = user;
        this.tasksList.add(task);
        cre1();
    }


    public void create(User user, List<Task> list) {
        clear();
        this.user = user;
        this.tasksList = list;
        cre1();
    }

    public void createAll(User user){
        clear();
        this.sourceUserTask.truncate();
        this.user = user;
        this.tasksList = builderTask.getAll();
        cre1();
    }

    private void clear(){
        this.userTasksList.clear();
        this.tasksList.clear();
    }

    private void cre1(){
        for (int i = 0; i < tasksList.size(); i++) {
            cre(user, tasksList.get(i));
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

