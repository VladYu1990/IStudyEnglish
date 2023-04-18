package ru.project.IStudyEnglish.domen.DTO.Answer;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Log4j2
public class ListAnswers {

    public ArrayList<Answer> listAnswer = new ArrayList<>(4);

    public String numberTrueAnswer;



    public ListAnswers(String listCodeFalseAnswers, String codeTrueAnswer){
        this.numberTrueAnswer = codeTrueAnswer;
        List<String> list = Arrays.asList(listCodeFalseAnswers.split("\\s*;\\s*"));;
        createListFalseAnswers(list);
        randomizationList();

    }

    private void createListFalseAnswers(List<String> list){
        for (int i=0;i<list.size();i++){
            String idAnswer = list.get(i);
            this.listAnswer.add(new Answer(idAnswer));
        }
    }

    private void randomizationList(){
        int number = ThreadLocalRandom.current().nextInt(0,3);
        this.listAnswer.add(number,new Answer(this.numberTrueAnswer));

    }
}



