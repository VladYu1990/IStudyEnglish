package ru.project.IStudyEnglish.DTO;

import java.util.ArrayList;

public class ListAnswers {
    public ArrayList<Answer> listAnswers;

    public ListAnswers(){
        listAnswers = new ArrayList<Answer>();

    }
    private ListAnswers newListAnswers(){
        return new ListAnswers();
    }
    
    public ListAnswers createListAnswers(){
        ListAnswers listAnswers = newListAnswers();
        return listAnswers;

    }

    public ArrayList<Answer> getListAnswers() {
        return listAnswers;
    }

    public void setListAnswers(ArrayList<Answer> listAnswers) {
        this.listAnswers = listAnswers;
    }
}
