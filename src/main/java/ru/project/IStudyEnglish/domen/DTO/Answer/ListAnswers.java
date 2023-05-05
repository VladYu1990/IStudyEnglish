package ru.project.IStudyEnglish.domen.DTO.Answer;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Log4j2
public class ListAnswers {

    private List<Answer> listAnswers = new ArrayList<>();

    public ListAnswers(String listTrueAnswers, String listFalseAnswers){

        createListAnswers(Arrays.asList(listTrueAnswers.split("\\s*;\\s*")),
                true);
        createListAnswers(Arrays.asList(listFalseAnswers.split("\\s*;\\s*")),
                false);
        randomizationList();

    }

    private void createListAnswers(List<String> list,boolean correct){
        for (int i=0;i<list.size();i++){
            String idAnswer = list.get(i);
            this.listAnswers.add(new Answer(idAnswer,correct));
        }
    }

    private void randomizationList(){
        Collections.shuffle(this.listAnswers);

    }

    public List<Answer> getListAnswers() {
        return listAnswers;
    }


}



