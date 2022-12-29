package ru.project.IStudyEnglish.DTO;

public class ListAnswers {
    //private ArrayList<Answer> listAnswers;
    private String test;

    public ListAnswers(){

        //this.listAnswers = Answer.getListOfSimilarAnswers(3);
        this.test = "test";
        System.out.println("лист ответов создан");

    }



    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
