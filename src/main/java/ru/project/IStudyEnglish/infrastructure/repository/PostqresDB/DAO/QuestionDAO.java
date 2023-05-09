package ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.DAO;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.WorkerWithPostgresDB;
import ru.project.IStudyEnglish.infrastructure.SourceQuestion;

import java.sql.ResultSet;

@Log4j2
public class QuestionDAO implements SourceQuestion, WorkerWithPostgresDB {
    private int id;
    private String value;
    private ResultSet data;

    public QuestionDAO(){

    }
    public void getOnId(String id){
        String sql = "select * from questions where id = ('" + id + "') limit 1";
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
        return id;
    }

    public String getValue() {
        return value;
    }
}
