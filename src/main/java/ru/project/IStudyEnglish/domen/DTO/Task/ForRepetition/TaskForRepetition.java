package ru.project.IStudyEnglish.domen.DTO.Task.ForRepetition;

import ru.project.IStudyEnglish.domen.DTO.Answer.ListAnswers;
import ru.project.IStudyEnglish.domen.DTO.Task.Task;


public abstract class TaskForRepetition extends Task {
    public String idSourceObject;
    public String typeSourceObject;
    public String question;
    public ListAnswers listAnswers;

    public TaskForRepetition(){
    }

    public TaskForRepetition(String id) {

    }
}
