package ru.project.IStudyEnglish.DTO;

import java.util.ArrayList;

public class Answer {
    private int id;
    private int idWord;
    private String spelling;
    private String value;
    private static PartOfSpeech partOfSpeech;
    private int formVerb;

    public Answer(){

    }

    public int getId(){
        return id;
    }
    private static Answer newAnswer(){
        return new Answer();
    }

    public static String getAnswerId(String id){ //переделать на возврат класса Answer
        //ответ зависит от слова для повторения
        Answer answer = newAnswer();
        return "1";

    }

    public static Answer getAnswerId(int id){ //переделать на возврат класса Answer
        //ответ зависит от слова для повторения
        Answer answer = newAnswer();
        return answer;

    }



    public static ArrayList<Answer> getListOfSimilarAnswers(int pieces){
        //тут возвращаем список похожих ответов
        //похожий ответ получаем так, берем ответ и находим в БД топ по похожести написания ответы
        //берем столько ответов, сколько пришло в запросе
        //возвращаем их коды
        ArrayList<Answer> listWrongAnswers = new ArrayList<>();
        listWrongAnswers.add(new Answer());
        listWrongAnswers.add(new Answer());
        listWrongAnswers.add(new Answer());
        return listWrongAnswers;
    }

}
