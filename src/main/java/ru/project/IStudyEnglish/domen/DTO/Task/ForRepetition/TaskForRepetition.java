package ru.project.IStudyEnglish.domen.DTO.Task.ForRepetition;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.domen.DTO.Answer.ListAnswers;
import ru.project.IStudyEnglish.domen.DTO.Task.UserTask.UserTask;
import ru.project.IStudyEnglish.infrastructure.DAO.TaskForRepetitionDAO;
import ru.project.IStudyEnglish.infrastructure.SourceTaskForRepetition;


@Log4j2
@Component
public class TaskForRepetition extends UserTask {
    public String idTaskForRepetition;
    public String idSourceObject;
    public String typeSourceObject;
    public String typeRepetition;
    public String question;
    public ListAnswers listAnswers;

    public TaskForRepetition(){

    }

    public TaskForRepetition(String id) {
        SourceTaskForRepetition task = new TaskForRepetitionDAO(id);
        this.idTaskForRepetition = task.getId();
        this.idSourceObject= task.getIdSourceObject();
        this.typeSourceObject = task.getTypeSourceObject();
        this.typeRepetition = task.getTypeRepetition();
        this.question = task.getQuestion();//из бд зависит от typeRepetition и typeTranslationDirection
        this.listAnswers = new ListAnswers(
                "1,2,3",//task.getStringFalseListAnswers(),
                task.getIdTrueAnswer());
    }
    public String getIdTaskForRepetition() {
        return idTaskForRepetition;
    }

    public String getIdSourceObject() {
        return idSourceObject;
    }

    public String getTypeSourceObject() {
        return typeSourceObject;
    }

    public String getTypeRepetition() {
        return typeRepetition;
    }

    public String getQuestion() {
        return question;
    }

    public ListAnswers getListAnswers() {
        return listAnswers;
    }

}
