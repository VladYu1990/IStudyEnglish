package ru.project.IStudyEnglish.learning_module.service.UserTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTaskStatusEnum;
import ru.project.IStudyEnglish.learning_module.repository.UserTask.UserTaskDAO;

import java.sql.Timestamp;

@Component
public class UpdaterUserTask {

    private UserTask userTask;

    private UserTaskDAO userTaskDAO;

    public UpdaterUserTask() {
    }

    @Autowired
    public UpdaterUserTask(UserTaskDAO userTaskDAO) {
        this.userTaskDAO = userTaskDAO;
    }

    public void setUserTask(UserTask userTask) {
        this.userTask = userTask;

    }
    public void updateForTrueResponse(){
        //порядок выполнения важен
        setTimeLastRepetition();
        setCorrectAttemptsCounter(true);
        setStatus();
        setTimeNextRepetition(true);
        update();
    }

    public void updateForFalseResponse(){
        //порядок выполнения важен
        setTimeLastRepetition();
        setCorrectAttemptsCounter(false);
        setStatus();
        setTimeNextRepetition(false);
        update();
    }

    private Timestamp now(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp;
    }

    private int nextDateRepetition(){
        int countDayPlus = 1;

        if (this.userTask.getStatus()== UserTaskStatusEnum.studied ||
                this.userTask.getCorrectAttemptsCounter()>3) {
                countDayPlus = this.userTask.getCorrectAttemptsCounter();
        }

        if (this.userTask.getStatus()== UserTaskStatusEnum.memorized){
            countDayPlus = 14;
        }

        return countDayPlus;
    }

    private void  setCorrectAttemptsCounter(boolean right){
        if(right == true){
            this.userTask.setCorrectAttemptsCounter(this.userTask.getCorrectAttemptsCounter()+1);
        }
        else {
            this.userTask.setCorrectAttemptsCounter(0);
        }
    }
    private void  setTimeLastRepetition(){
        this.userTask.setTimeLastRepetition(now());
    }
    private void  setTimeNextRepetition(boolean right){
        if(right = true){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis() + nextDateRepetition()*1000*60*60*24);

            this.userTask.setTimeNextRepetition(timestamp);
        }
        else {
            this.userTask.setTimeNextRepetition(now());
        }

    }
    private void  setStatus(){
        if(this.userTask.getStatus() == UserTaskStatusEnum.studied
                || this.userTask.getCorrectAttemptsCounter()>5 ){
            this.userTask.setStatus(UserTaskStatusEnum.memorized);
        }
    }

    private void update(){
        userTaskDAO.update(this.userTask);

    }
}
