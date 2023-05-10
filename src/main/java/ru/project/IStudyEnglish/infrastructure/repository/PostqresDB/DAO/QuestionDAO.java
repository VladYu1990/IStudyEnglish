package ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.DAO;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.ConnectDB;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.WorkerWithPostgresDB;
import ru.project.IStudyEnglish.infrastructure.SourceQuestion;
import ru.project.IStudyEnglish.infrastructure.repository.StringSQL;

import java.sql.ResultSet;

@Log4j2
public class QuestionDAO implements SourceQuestion, WorkerWithPostgresDB {
    private int id;
    private String value;
    private ResultSet data;
    private ConnectDB conDB;

    public QuestionDAO(){
    }

    @Autowired
    public QuestionDAO(ConnectDB conDB){
        this.conDB = conDB;
    }

    public void getOnId(String id){
        String sql = "select * from questions where id = ('" + id + "') limit 1";
        fillFromData(sql);
    }

    private void fillFromData(String sql){
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
        return id;
    }

    public String getValue() {
        return value;
    }
}
