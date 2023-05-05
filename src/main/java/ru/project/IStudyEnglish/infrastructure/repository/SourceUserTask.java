package ru.project.IStudyEnglish.infrastructure.repository;

import ru.project.IStudyEnglish.domen.DTO.Task.TypeTask;

import java.sql.Timestamp;


public interface SourceUserTask {

    static String getNext() {
        return null;
    }
    void setStatus(String status);
    void setTimeLastRepetition(Timestamp timeLastRepetition);
    void setTimeNextRepetition(Timestamp timeNextRepetition);
    void setCorrectAttemptsCounter(String correctAttemptsCounter);
    String getId();
    String getUserCode();
    String getIdTask();
    TypeTask getTypeTask();
    String getStatus();
    Timestamp getTimeLastRepetition();
    Timestamp getTimeNextRepetition();
    String getCorrectAttemptsCounter();
    void fillNextForUser(String userCode);
    void fillById(String taskId);

}
