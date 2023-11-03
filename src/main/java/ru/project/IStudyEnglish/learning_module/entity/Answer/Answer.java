package ru.project.IStudyEnglish.learning_module.entity.Answer;

public class Answer {
    // цель: ответ на конкретный вопрос
    // TODO Для этой цели завести справочник ответов :цель объекта это хранение возможных ответов, например "Да","облако","костыль"
    private int id;
    private String value;

    private TypeAnswer typeAnswer;

    public Answer(int id, String value, TypeAnswer typeAnswer) {
        this.id = id;
        this.value = value;
        this.typeAnswer = typeAnswer;
    }

    public Answer(int id, String value) {
        //TODO получаем из бд
        this.value = value;
    }

    public Answer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TypeAnswer getTypeAnswer() {
        return typeAnswer;
    }

    public void setTypeAnswer(TypeAnswer typeAnswer) {
        this.typeAnswer = typeAnswer;
    }
}
