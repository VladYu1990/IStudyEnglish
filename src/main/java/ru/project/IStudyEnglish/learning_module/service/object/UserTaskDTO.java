package ru.project.IStudyEnglish.learning_module.service.object;

import ru.project.IStudyEnglish.learning_module.entity.Answer.Answer;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;

import java.util.List;

public class UserTaskDTO {

    int  userTaskId;
    String question;
    List<Answer> answersList;
    String trueAnswer;

    public UserTaskDTO(UserTask userTask, List<Answer> answersList, String answerTrue) {
        this.answersList = answersList;
        this.userTaskId = userTask.getId();
        this.question = userTask.getTask().getQuestion();
        this.trueAnswer = answerTrue;
    }

    public int getUserTaskId() {
        return userTaskId;
    }

    public void setUserTaskId(int userTaskId) {
        this.userTaskId = userTaskId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answer> answersList) {
        this.answersList = answersList;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }
}
