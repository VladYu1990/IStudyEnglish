package ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.DAO;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.infrastructure.SourceAnswer;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.ConnectDB;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.WorkerWithPostgresDB;
import ru.project.IStudyEnglish.infrastructure.repository.StringSQL;

import java.sql.ResultSet;
@Log4j2
@Component
public class AnswerDAO implements SourceAnswer, WorkerWithPostgresDB {

    private int id;
    private String value;
    private ResultSet data;
    private ConnectDB conDB;

    public AnswerDAO(){

    }

    @Autowired
    public AnswerDAO(ConnectDB conDB){
        this.conDB = conDB;
    }

    public void fillOnId(int id) {
        String sql = "Select * from answers where id = ('" + id + "') limit 1";
        readFromDB(sql);

    }

    private void readFromDB(String sql){
        this.data = read(new StringSQL(sql),conDB);
        try {
            while (data.next()) {
                this.id = Integer.valueOf(data.getString("id"));
                this.value = data.getString("value");
            }
        } catch (Exception ex) {
            log.error(ex);
        }
    }

    public int getId() {
        return this.id;
    }

    public String getValue() {
        return this.value;
    }
}
