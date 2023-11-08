package ru.project.IStudyEnglish.learning_module.service.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;
import ru.project.IStudyEnglish.learning_module.service.UserTask.UserTackDAOAdapter;
import ru.project.IStudyEnglish.learning_module.service.UserTask.UpdaterUserTask;

@Component
public class AnswerChecker {

    public UpdaterUserTask updaterUserTask;
    public UserTackDAOAdapter userTackDAOAdapter;

    public AnswerChecker() {
    }

    @Autowired
    public AnswerChecker(UpdaterUserTask updaterUserTask, UserTackDAOAdapter userTackDAOAdapter) {
        this.updaterUserTask = updaterUserTask;
        this.userTackDAOAdapter = userTackDAOAdapter;
    }

    public void check(int idUserTask, int id_answer){
        UserTask userTask = userTackDAOAdapter.get(idUserTask);
        updaterUserTask.setUserTask(userTask);
        //Todo add save answer(id,time) for history answers
        if(userTask.getTask().getTrueAnswer()==id_answer){
            updaterUserTask.updateForTrueResponse();
        }
        else {
            updaterUserTask.updateForFalseResponse();
        }
    }
}
