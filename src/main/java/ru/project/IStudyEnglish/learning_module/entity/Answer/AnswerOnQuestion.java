package ru.project.IStudyEnglish.learning_module.entity.Answer;

public class AnswerOnQuestion {
    //цель объекта это хранение ответа на конкретный вопрос,
    // когда ответ может быть верным или нет
    // например, "ты человек?" - "Да", "на чем держится твой код?" - "на костылях"
    private int answerId;//как ссылка на источник,
    // чтоб при получении ответа можно было понять,
    // какой ответ выбрал юзер,
    // чтобы была статистика какие ответы юзер выбирает
    private String value;
    private boolean correct;

    public AnswerOnQuestion(int id,String value, boolean correct){
        this.answerId = id;
        this.value = value;
        this.correct = correct;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
