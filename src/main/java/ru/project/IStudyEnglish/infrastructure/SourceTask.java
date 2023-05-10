package ru.project.IStudyEnglish.infrastructure;


import org.springframework.stereotype.Component;

@Component
public interface SourceTask {

    public int getId();

    public String getTypeTask() ;

    public String getQuestion() ;

    public String getListTrueAnswers();

    public String getListFalseAnswers();

    public String getTranslationDirection();

    public void fillOnId(int id);
}
