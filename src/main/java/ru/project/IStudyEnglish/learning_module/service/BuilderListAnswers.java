package ru.project.IStudyEnglish.learning_module.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Answer.Answer;
import ru.project.IStudyEnglish.learning_module.repository.ListAnswers.ListAnswersDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Log4j2
public class BuilderListAnswers {

    private List<Answer> answerList = new ArrayList<Answer>();

    private ListAnswersDAO listAnswersDAO;

    public BuilderListAnswers() {

    }

    public List<Answer> getAnswersList(String answer){
        this.answerList.addAll(
                listAnswersDAO.getList(answer));
        randomizeList(this.answerList);
        return answerList;
    }

    private void randomizeList(List list){
        Collections.shuffle(list);
    }
}
