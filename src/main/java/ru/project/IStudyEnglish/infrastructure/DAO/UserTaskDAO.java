package ru.project.IStudyEnglish.infrastructure.DAO;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.infrastructure.ConnectDB;
import ru.project.IStudyEnglish.infrastructure.repository.SourceUserTask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

@Log4j2
public class UserTaskDAO implements SourceUserTask {
    private String id;
    private String userCode;
    private String idTask;
    private String typeTask;
    private String status;
    private Timestamp timeLastRepetition;
    private Timestamp timeNextRepetition;
    private String correctAttemptsCounter;
    private ConnectDB conDB = new ConnectDB();

    public UserTaskDAO(){
    }

    public void getById(String id){
        String sql = "select * from user_task where id in ('"+ id + "') limit 1";
        readFromDB(sql);

    }

    public void getNextForUser(String userCode){
        String sql = "select * " +
                "from user_task " +
                "where user_code in ('"+ id + "')  " +
                "and status <> ('8')" +
                "and time_next_repetition <= clock_timestamp()" + //наступившее
                "order by time_next_repetition " + // но самое новое, иначе если пользователь будет редко заходить он будет повторять только старые слова не доходя до недавних и тем самым, будут большие перерерывы в повторении
                "limit 1";
    }

    private void readFromDB(String sql){
        try {
            ResultSet resultSet = conDB.getResultSet(sql );

            while (resultSet.next()) {
                this.id = resultSet.getString("id");
                this.userCode = resultSet.getString("user_code");
                this.idTask = resultSet.getString("id_task");
                this.typeTask = resultSet.getString("type_task");
                this.status = resultSet.getString("status");
                this.timeLastRepetition = resultSet.getTimestamp("time_last_repetition");
                this.timeNextRepetition = resultSet.getTimestamp("time_next_repetition");
                this.correctAttemptsCounter = resultSet.getString("correct_attempts_counter");

            }
            conDB.getStatement().close();
        } catch (Exception ex) {
            log.error(ex);
        }
    }




    public void setStatus(String status) {
        this.status = status;
        String sqlUpdate = "UPDATE user_task SET status = '" + this.status + "' WHERE id = '" + this.id + "';";
        conDB.update(sqlUpdate);
    }

    public void setTimeLastRepetition(Timestamp timeLastRepetition) {
        this.timeLastRepetition = timeLastRepetition;
        String sqlUpdate = "UPDATE user_task SET timeLastRepetition = '" + this.timeLastRepetition + "' WHERE id = '" + this.id + "';";
        conDB.update(sqlUpdate);
    }

    public void setTimeNextRepetition(Timestamp timeNextRepetition) {
        this.timeNextRepetition = timeNextRepetition;
        String sqlUpdate = "UPDATE user_task SET timeNextRepetition = '" + this.timeNextRepetition + "' WHERE id = '" + this.id + "';";
        conDB.update(sqlUpdate);
    }

    public void setCorrectAttemptsCounter(String correctAttemptsCounter) {
        this.correctAttemptsCounter = correctAttemptsCounter;
        String sqlUpdate = "UPDATE user_task SET correctAttemptsCounter = '" + this.correctAttemptsCounter + "' WHERE id = '" + this.id + "';";
        conDB.update(sqlUpdate);
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

    public Timestamp getTimeLastRepetition() {
        return timeLastRepetition;
    }

    public Timestamp getTimeNextRepetition() {
        return timeNextRepetition;
    }

    public String getCorrectAttemptsCounter() {
        return correctAttemptsCounter;
    }
}
