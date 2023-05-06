package ru.project.IStudyEnglish.infrastructure;

public interface SourceTaskForRepetition {

    String getId();
    String getIdSourceObject();
    String getTypeSourceObject();
    String getTypeRepetition();
    String getQuestion();
    String getStringFalseListAnswers();
    String getIdTrueAnswer();
}
