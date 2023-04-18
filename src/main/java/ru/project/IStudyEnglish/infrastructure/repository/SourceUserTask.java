package ru.project.IStudyEnglish.infrastructure.repository;

public interface SourceUserTask {

    static String getNext() {
        return null;
    }
    void setStatus(String status);
    void setTimeLastRepetition(String timeLastRepetition);
    void setTimeNextRepetition(String timeNextRepetition);
    void setCorrectAttemptsCounter(String correctAttemptsCounter);
    void update(String id);
    String getId();
    String getUserCode();
    String getIdTask();
    String getTypeTask();
    String getStatus();
    String getTimeLastRepetition();
    String getTimeNextRepetition();
    String getCorrectAttemptsCounter();
}
