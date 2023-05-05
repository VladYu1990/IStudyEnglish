package ru.project.IStudyEnglish.infrastructure.repository;

public interface SourceTask {

    public String getId();

    public String getTypeTask() ;

    public String getQuestion() ;

    public String getListTrueAnswers();

    public String getListFalseAnswers();

    public String getTranslationDirection();
}
