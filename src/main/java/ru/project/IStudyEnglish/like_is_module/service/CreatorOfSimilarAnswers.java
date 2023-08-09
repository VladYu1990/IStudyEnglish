package ru.project.IStudyEnglish.like_is_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Answer.Answer;
import ru.project.IStudyEnglish.learning_module.entity.Answer.TypeAnswer;
import ru.project.IStudyEnglish.learning_module.repository.Answer.AnswersListDAO;
import ru.project.IStudyEnglish.learning_module.service.BuilderAnswer;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreatorOfSimilarAnswers {

    private Answer answer;

    private List<Answer> answerList= new ArrayList<Answer>();
    BuilderAnswer builderAnswer;
    AnswersListDAO answersListDAO;


    public CreatorOfSimilarAnswers() {
    }

    @Autowired
    public CreatorOfSimilarAnswers(BuilderAnswer builderAnswer, AnswersListDAO answersListDAO) {
        this.builderAnswer = builderAnswer;
        this.answersListDAO = answersListDAO;
    }

    public void create(Answer answer) {
        this.answer = answer;
        if (answer.getTypeAnswer().equals(TypeAnswer.textEng) || answer.getTypeAnswer().equals(TypeAnswer.textRus)){
            get();//получили весь список ответов
            similar();//рассчитай похожесть
            sort();// выстрои похожесть от топ к дну
            //выбери сколько нужно похожих
            save(3);// сохрани
        }

    }

    private void get(){
        this.answerList = builderAnswer.getAll(this.answer.getTypeAnswer());//сразу режем по типу
    }

    private void similar(){
//TODO

        /*LevenshteinDistance l = new LevenshteinDistance();
        double d = (dd-l.apply("abc123458","ab12345678"))/dd;

        List<Double,Double> list = new ArrayList<>();*/

    }

    private  void sort(){
        //TODO
    }

    private void choose(){

    }

    private void save(int count){
        String str = "";
        //todo

        for (int i = 0;i<count;i++){
            int r = (int)(Math.random()*answerList.size());
            if(answerList.get(r).getId()==answer.getId()){
                r = (int)(Math.random()*answerList.size());
            }
            str = str + answerList.get(r).getId() + ";";
        }
        answersListDAO.create(answer.getId(),str);
    }




}
