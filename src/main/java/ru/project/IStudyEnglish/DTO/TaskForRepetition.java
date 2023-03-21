package ru.project.IStudyEnglish.DTO;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class TaskForRepetition {
    public String typeObject;
    public int idObject;
    public String writingObject;
    public String  trueAnswer;
    public ListAnswers listAnswers;
    public String likeThisWord;

    public TaskForRepetition(String object, int id) throws SQLException {
        if (object=="word"){
            Word word = new Word(id);
            this.typeObject = object;
            this.idObject = id;
            this.writingObject = word.writing;
            this.trueAnswer = word.value;
            this.likeThisWord=word.likeThisWord;
            List<String> items = Arrays.asList(likeThisWord.split("\\s*;\\s*"));
            System.out.println(items);
            this.listAnswers = new ListAnswers(
                    id,
                    Integer.parseInt(items.get(0)),
                    Integer.parseInt(items.get(1)),
                    40);
        }
        else {
            System.out.println("не известный объект");
        }

    }


    public ListAnswers getListAnswers() {
        return listAnswers;
    }


    public void setListAnswers(ListAnswers listAnswers) {
        this.listAnswers = listAnswers;
    }
}
