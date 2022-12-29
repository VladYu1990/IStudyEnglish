package ru.project.IStudyEnglish.DTO;

import org.springframework.stereotype.Component;

@Component
public class TaskForRepetition {
    private int TypeExercise; // вопрос или правило

    private Question question;
    private ListAnswers listAnswers;

    private RuleForStudy ruleForStudy;
    private Example example;

    public TaskForRepetition(){
        this.TypeExercise = 1;
        this.question = new Question();
        this.listAnswers = new ListAnswers();
        this.ruleForStudy = new RuleForStudy();
        this.example = new Example();
    }

    public int getTypeExercise() {
        return TypeExercise;
    }

    public void setTypeExercise(int typeExercise) {
        TypeExercise = typeExercise;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public ListAnswers getListAnswers() {
        return listAnswers;
    }

    public void setListAnswers(ListAnswers listAnswers) {
        this.listAnswers = listAnswers;
    }

    public RuleForStudy getRuleForStudy() {
        return ruleForStudy;
    }

    public void setRuleForStudy(RuleForStudy ruleForStudy) {
        this.ruleForStudy = ruleForStudy;
    }

    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }
}
