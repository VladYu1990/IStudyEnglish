package ru.project.IStudyEnglish.learning_module.repository.UserTask;

import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.user_module.entity.User.User;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;

import java.util.List;


@Component
public interface SourceUserTask {


    UserTask getNext(User user);
    UserTask getOnId(int id);

    void save(UserTask userTask);

    void save(List<UserTask> list);

}
