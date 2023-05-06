package ru.project.IStudyEnglish.infrastructure;

public interface SourceTask {

    public int getId();

    public String getTypeTask() ;

    public String getQuestion() ;

    public String getListTrueAnswers();

    public String getListFalseAnswers();

    public String getTranslationDirection();
}
