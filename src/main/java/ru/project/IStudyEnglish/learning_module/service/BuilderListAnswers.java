package ru.project.IStudyEnglish.learning_module.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Answer.AnswerOnQuestion;
import ru.project.IStudyEnglish.learning_module.repository.Answer.AnswersListDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Log4j2
public class BuilderListAnswers {

    private AnswersListDAO answersListDAO;
    private int countAnswers;

    public BuilderListAnswers() {

    }

    @Autowired
    public BuilderListAnswers(AnswersListDAO answersListDAO) {
        this.answersListDAO = answersListDAO;
    }

    public List<AnswerOnQuestion> getList(int idAnswer, int countAnswers){

          return answersListDAO.get(idAnswer,countAnswers);

    }

    public List<AnswerOnQuestion> getRandomList(int idAnswer, int countAnswers){
        List<AnswerOnQuestion> listRandom = new ArrayList<>();
        listRandom = answersListDAO.get(idAnswer,countAnswers);
        Collections.shuffle(listRandom);

        return listRandom;
    }
}
