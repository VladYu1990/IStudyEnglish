package ru.project.IStudyEnglish.DTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class TaskForRepetition {
    public String typeObject;
    public int idObject;
    public String writingObject;
    public String  trueAnswer;
    public ListAnswers listAnswers;

    public TaskForRepetition(String object, int id) throws SQLException {
        if (object=="word"){
            Word word = new Word(id);
            this.typeObject = object;
            this.idObject = word.id;
            this.writingObject = word.writing;
            this.trueAnswer = word.value;
            List<Integer> likeThisWordList = createList(word.likeThisWord);
            this.listAnswers = new ListAnswers(
                    id,
                    likeThisWordList.get(0),
                    likeThisWordList.get(1),
                    likeThisWordList.get(2));
        }
        else {
            System.out.println("не известный объект");
        }

    }

    public List<Integer> createList(String stringLikeThisWord){
        List<Integer> listInt = new ArrayList<>();
        List<String> listString = Arrays.asList(stringLikeThisWord.split("\\s*;\\s*"));
        for (int i=0;i<listString.size()-1;i++){
            listInt.add(Integer.valueOf(listString.get(i)));
        }

        while (listInt.size()<3){
           int randomNumber = ThreadLocalRandom.current().nextInt(1,100);
           listInt.add(randomNumber);
       }

        return listInt;

    }

}
