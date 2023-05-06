package ru.project.IStudyEnglish.infrastructure.DAO;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.infrastructure.SourceAnswer;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.WorkerWithPostgresDB;

import java.sql.ResultSet;
@Log4j2
public class AnswerDAO implements SourceAnswer, WorkerWithPostgresDB {

    private int id;
    private String value;
    private ResultSet data;

    public AnswerDAO(){

    }

    public AnswerDAO(String id) {
        String sql = "Select * from answers where id = ('" + id + "') limit 1";
        fillFromData(sql);

    }

    private void fillFromData(String sql){
        this.data = read(sql);
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
