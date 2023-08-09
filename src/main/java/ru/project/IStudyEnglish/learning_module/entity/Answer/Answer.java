package ru.project.IStudyEnglish.learning_module.entity.Answer;

public class Answer {
    // цель: ответ на конкретный вопрос
    // TODO Для этой цели завести справочник ответов :цель объекта это хранение возможных ответов, например "Да","облако","костыль"
    private String value = "тестовый ответ";
    private boolean correct;

    public Answer() {
    }

    public Answer(String value,boolean correct){
        this.value = value;
        this.correct = correct;

    }

    public Answer(int id, String value) {
        //TODO получаем из бд
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
