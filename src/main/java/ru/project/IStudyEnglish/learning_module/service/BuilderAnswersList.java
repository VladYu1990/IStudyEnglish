package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Answer.Answer;
import ru.project.IStudyEnglish.learning_module.repository.Answer.AnswersListDAO;

import java.util.List;

@Component
public class BuilderAnswersList {

    AnswersListDAO answerListDAO;
    BuilderAnswer builderAnswer;
    public BuilderAnswersList() {}

    @Autowired
    public BuilderAnswersList(AnswersListDAO answerListDAO, BuilderAnswer builderAnswer) {
        this.answerListDAO = answerListDAO;
        this.builderAnswer = builderAnswer;
    }

    public List<Answer> get(int id){

        return builderAnswer.get(answerListDAO.get(id));
    }

}
