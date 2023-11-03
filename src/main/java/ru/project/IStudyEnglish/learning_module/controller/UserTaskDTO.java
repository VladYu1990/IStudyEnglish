package ru.project.IStudyEnglish.learning_module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Answer.AnswerOnQuestion;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;
import ru.project.IStudyEnglish.like_it_module.service.BuilderSimilarAnswers;

import java.util.List;


@Component
public class UserTaskDTO {

    int  userTaskId;
    String question;
    List<AnswerOnQuestion> listAnswer;
    BuilderSimilarAnswers builderSimilarAnswers;


    public UserTaskDTO() {
    }
    @Autowired
    public UserTaskDTO(BuilderSimilarAnswers builderSimilarAnswers) {
        this.builderSimilarAnswers = builderSimilarAnswers;
    }


    public void setUserTask(UserTask userTask) {
        setUserTaskId(userTask.getId());
        setQuestion(userTask.getTask().getQuestion());
        setListAnswer(userTask.getTask().getTrueAnswer(),4);
    }

    public void setUserTaskId(int userTaskId) {this.userTaskId = userTaskId;}

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setListAnswer(int idTrueAnswer, int count) {
        this.listAnswer = builderSimilarAnswers.getRandomList(idTrueAnswer,count);

    }

    public int getUserTaskId() {
        return userTaskId;
    }

    public String getQuestion() {
        return question;
    }

    public List<AnswerOnQuestion> getListAnswer() {
        return listAnswer;
    }

}
