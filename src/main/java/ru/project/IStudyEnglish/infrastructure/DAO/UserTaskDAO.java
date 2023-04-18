package ru.project.IStudyEnglish.infrastructure.DAO;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.infrastructure.ConnectDB;
import ru.project.IStudyEnglish.infrastructure.repository.SourceUserTask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class UserTaskDAO implements SourceUserTask {
    private String id;
    private String userCode;
    private String idTask;
    private String typeTask;
    private String status;
    private String timeLastRepetition;
    private String timeNextRepetition;
    private String correctAttemptsCounter;

    public UserTaskDAO(String id){
        try {
            ConnectDB conDB = new ConnectDB();
            String sql = "select * from user_task  where id in ('";
            ResultSet resultSet = conDB.getResultSet(sql + id + "') limit 1");

            while (resultSet.next()) {
                this.id = resultSet.getString("id");
                this.userCode = resultSet.getString("user_code");
                this.idTask = resultSet.getString("id_task");
                this.typeTask = resultSet.getString("type_task");
                this.status = resultSet.getString("status");
                this.timeLastRepetition = resultSet.getString("time_last_repetition");
                this.timeNextRepetition = resultSet.getString("time_next_repetition");
                this.correctAttemptsCounter = resultSet.getString("correct_attempts_counter");

            }

            resultSet.close();
        }
        catch (Exception ex){
            log.error(ex);
        }


    }


    public static String getNext(String userCode){
        return null;
    }

    public void setStatus(String status) {
        try {
            this.status = status;
            String sqlUpdate = "UPDATE user_task SET status = '" + this.status + "' WHERE id = '" + this.id + "';";
            ConnectDB conDB = new ConnectDB();
            Statement statement = conDB.getStatement();
            statement.executeUpdate(sqlUpdate);
        }
        catch (SQLException sqlException){
            log.error(sqlException);
        }
    }

    public void setTimeLastRepetition(String timeLastRepetition) {
        this.timeLastRepetition = timeLastRepetition;
    }

    public void setTimeNextRepetition(String timeNextRepetition) {
        this.timeNextRepetition = timeNextRepetition;
    }

    public void setCorrectAttemptsCounter(String correctAttemptsCounter) {
        this.correctAttemptsCounter = correctAttemptsCounter;
    }

    @Override
    public void update(String id) {
        try {
            ConnectDB conDB = new ConnectDB();

        }
        catch (Exception ex){
            log.error(ex);
        }
    }


    public String getId() {
        return id;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getIdTask() {
        return idTask;
    }

    public String getTypeTask() {
        return typeTask;
    }

    public String getStatus() {
        return status;
    }

    public String getTimeLastRepetition() {
        return timeLastRepetition;
    }

    public String getTimeNextRepetition() {
        return timeNextRepetition;
    }

    public String getCorrectAttemptsCounter() {
        return correctAttemptsCounter;
    }
}
