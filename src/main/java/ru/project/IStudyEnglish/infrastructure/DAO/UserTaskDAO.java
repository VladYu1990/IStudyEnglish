package ru.project.IStudyEnglish.infrastructure.DAO;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.domen.DTO.Task.TypeTask;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.WorkerWithPostgresDB;
import ru.project.IStudyEnglish.infrastructure.repository.SourceUserTask;

import java.sql.ResultSet;
import java.sql.Timestamp;

@Log4j2
public class UserTaskDAO implements SourceUserTask, WorkerWithPostgresDB {
    private String id;
    private String userCode;
    private String idTask;
    private TypeTask typeTask;
    private String status;
    private Timestamp timeLastRepetition;
    private Timestamp timeNextRepetition;
    private String correctAttemptsCounter;
    private ResultSet data;

    public UserTaskDAO(){
    }


    @Override
    public void fillById(String id){
        String sql = "select * from user_task where id in ('"+ id + "') limit 1";
        fillFromDB(sql);
        log.error("fillById");
    }

    public void fillNextForUser(String userCode){
        String sql = "select * " +
                "from user_task " +
                "where user_code in ('"+ userCode + "')  " +
                "and status <> ('3')" + //это статус заданий для изучения/повторения, остальные или рано или уже выучили
                "and time_next_repetition <= clock_timestamp()" + //наступившее
                "order by time_next_repetition " + // но самое новое, иначе если пользователь будет редко заходить он будет повторять только старые слова не доходя до недавних и тем самым, будут большие перерерывы в повторении
                "limit 1";
        fillFromDB(sql);
    }

    private void fillFromDB(String sql){
        data = read(sql);
        try {
            while (data.next()) {
                this.id = data.getString("id");
                this.userCode = data.getString("user_code");
                this.idTask = data.getString("id_task");
                this.typeTask = TypeTask.valueOf(data.getString("type_task"));
                this.status = data.getString("status");
                this.timeLastRepetition = data.getTimestamp("time_last_repetition");
                this.timeNextRepetition = data.getTimestamp("time_next_repetition");
                this.correctAttemptsCounter = data.getString("correct_attempts_counter");

            }
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

    public TypeTask getTypeTask() {
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
