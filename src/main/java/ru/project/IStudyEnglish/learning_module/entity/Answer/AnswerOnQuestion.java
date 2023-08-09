package ru.project.IStudyEnglish.learning_module.entity.Answer;

public class AnswerOnQuestion {
    //цель объекта это хранение ответа на конкретный вопрос,
    // когда ответ может быть верным или нет
    // например, "ты человек?" - "Да", "на чем держится твой код?" - "на костылях"
    private Answer answer;//как ссылка на источник,
    // чтоб при получении ответа можно было понять,
    // какой ответ выбрал юзер,
    // чтобы была статистика какие ответы юзер выбирает
    private String value;
    private boolean correct;

    public AnswerOnQuestion(Answer answer, boolean correct){
        this.answer = answer;
        this.value = answer.getValue();
        this.correct = correct;
    }

}
