package ru.project.IStudyEnglish.infrastructure.repository;

public interface SourceTaskForRepetition {

    String getId();
    String getIdSourceObject();
    String getTypeSourceObject();
    String getTypeRepetition();
    String getQuestion();
    String getStringFalseListAnswers();
    String getIdTrueAnswer();
}
