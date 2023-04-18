package ru.project.IStudyEnglish.domen.DTO.Answer;

public class Answer {
    private String id;
    private String value;

    public Answer(){

    }

    public Answer(String id)  {
        //WordForRepetition w = new WordForRepetition(idWord);
        this.id = id;
        this.value="тестовое значение";

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
