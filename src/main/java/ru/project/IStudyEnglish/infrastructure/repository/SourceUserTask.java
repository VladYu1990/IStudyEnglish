package ru.project.IStudyEnglish.infrastructure.repository;

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
    String getTypeTask();
    String getStatus();
    Timestamp getTimeLastRepetition();
    Timestamp getTimeNextRepetition();
    String getCorrectAttemptsCounter();
    void getById(String id);
    void getNextForUser(String userCode);
}
