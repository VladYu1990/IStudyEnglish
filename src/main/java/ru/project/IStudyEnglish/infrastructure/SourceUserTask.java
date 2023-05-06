package ru.project.IStudyEnglish.infrastructure;

import ru.project.IStudyEnglish.domen.DTO.Task.TypeTask;

import java.sql.Timestamp;


public interface SourceUserTask {

    static String getNext() {
        return null;
    }
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
    void fillNextForUser(String userCode);
    void fillViaId(int taskId);

    void update();
}
