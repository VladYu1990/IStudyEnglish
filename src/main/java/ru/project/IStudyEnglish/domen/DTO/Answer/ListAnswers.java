package ru.project.IStudyEnglish.domen.DTO.Answer;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Log4j2
@Component
public class ListAnswers {

    private List<Answer> listAnswers = new ArrayList<>();
    private Answer answer;
    public ListAnswers(){
    }

    @Autowired
    public ListAnswers(Answer answer){
        this.answer = answer;
        log.error("added answer" + answer.toString());

    }



    public void fill(String listTrueAnswers, String listFalseAnswers){

        createListAnswers(Arrays.asList(listTrueAnswers.split("\\s*;\\s*")),
                true);
        createListAnswers(Arrays.asList(listFalseAnswers.split("\\s*;\\s*")),
                false);
        randomizationList();

    }

    private void createListAnswers(List<String> list,boolean correct){
        for (int i=0;i<list.size();i++){
            this.answer.fillOnId(Integer.parseInt(list.get(i)),correct);
            this.listAnswers.add(answer);
        }
    }

    private void addAnswerInList(){

    }

    private void randomizationList(){
        Collections.shuffle(this.listAnswers);

    }

    public List<Answer> getListAnswers() {
        return listAnswers;
    }


}



