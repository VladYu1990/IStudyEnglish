package ru.project.IStudyEnglish.learning_module.service.object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.repository.UserTask.UserTaskDAO;
import ru.project.IStudyEnglish.user_module.entity.User.User;

@Component
public class VoterNextUserTask {
    private User user;
    private int nextUserTask;
    private UserTaskDAO userTaskDAO;


    @Autowired
    public VoterNextUserTask(UserTaskDAO userTaskDAO) {
        this.userTaskDAO = userTaskDAO;
    }

    public int getNext(User user){
        this.user = user;
        choose();
        return nextUserTask;
    }

    private void choose(){
        this.nextUserTask = userTaskDAO.getNext(this.user);
    }


}
