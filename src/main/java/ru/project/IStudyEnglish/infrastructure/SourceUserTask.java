package ru.project.IStudyEnglish.infrastructure;

import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.domen.DTO.Task.TypeTask;

import java.sql.Timestamp;


@Component
public interface SourceUserTask {


    void getNext(String idUser);
    void getOnId(int id);
    void setStatus(int status);
    void setTimeLastRepetition(Timestamp timeLastRepetition);
    void setTimeNextRepetition(Timestamp timeNextRepetition);
    void setCorrectAttemptsCounter(int correctAttemptsCounter);
    int getId();
    int getUserCode();
    int getIdTask();
    TypeTask getTypeTask();
    int getStatus();
    Timestamp getTimeLastRepetition();
    Timestamp getTimeNextRepetition();
    int getCorrectAttemptsCounter();
    void update();
}
