package ru.project.IStudyEnglish.like_is_module.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Answer.Answer;
import ru.project.IStudyEnglish.learning_module.repository.Answer.AnswersListDAO;
import ru.project.IStudyEnglish.learning_module.service.BuilderAnswer;
import ru.project.IStudyEnglish.like_is_module.SimilarityAnswer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CreatorOfSimilarAnswers {

    private List<Answer> answerList = new ArrayList<>() ;

    private List<Answer> allAnswerList = new ArrayList<>();
    private List<SimilarityAnswer> similarityAnswerList = new ArrayList<>();
    BuilderAnswer builderAnswer;
    AnswersListDAO answersListDAO;


    public CreatorOfSimilarAnswers() {
    }

    @Autowired
    public CreatorOfSimilarAnswers(BuilderAnswer builderAnswer, AnswersListDAO answersListDAO) {
        this.builderAnswer = builderAnswer;
        this.answersListDAO = answersListDAO;
    }

    public void create(int id) {
        answerList.add(builderAnswer.get(id));
        workForAll();
    }

    public void create() {
        answersListDAO.truncateTable();
        answerList.addAll(builderAnswer.getAll());
        //answerList.add(builderAnswer.get(14093));
        workForAll();
    }


    private void workForAll(){
        similarityAnswerList.clear();
        allAnswerList = builderAnswer.getAll();
        for(int i = 0;i<answerList.size();i++){
            workOne(answerList.get(i));
        }
        save();
    }

    private void workOne(Answer answer){
        List<SimilarityAnswer> similarityAnswers = new ArrayList<>();
        for(int i = 0;i<allAnswerList.size();i++){
            if (answer.getId() != allAnswerList.get(i).getId()) {

                similarityAnswers.add(createSimilarAnswer(
                        answer,allAnswerList.get(i)));
            }
        }
        sortDesk(similarityAnswers);
        this.similarityAnswerList.addAll(similarityAnswers.subList(0,10));


    }

    private SimilarityAnswer createSimilarAnswer(Answer answer1,Answer answer2) {
            return
                    new SimilarityAnswer(
                            answer1.getId(),
                            answer2.getId(),
                            similarityInPercentage(
                                    answer1.getValue(),
                                    answer2.getValue()));
    }

    private int similarityInPercentage(String s1, String s2){

        int max = Math.max(s1.length(),s2.length());
        return ((max - StringUtils.getLevenshteinDistance(s1, s2))*100)/max;
    }

    private  void sortDesk(List<SimilarityAnswer> similarityAnswer) {
        Collections.sort(similarityAnswer, Collections.reverseOrder());
    }


    private void save() {
        sortDesk(this.similarityAnswerList);//без этого сохраняется не в сортированном виде, видимо добавление в этот лист ломает сортировку
        answersListDAO.create(this.similarityAnswerList);
    }





}
