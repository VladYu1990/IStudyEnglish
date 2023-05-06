package ru.project.IStudyEnglish.infrastructure.DAO;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.infrastructure.repository.PostqresDB.WorkerWithPostgresDB;
import ru.project.IStudyEnglish.infrastructure.SourceTask;

import java.sql.ResultSet;

@Log4j2
public class TaskDAO implements SourceTask, WorkerWithPostgresDB {
    private int id;
    private String typeTask;
    private String question;
    private String listTrueAnswers;
    private String listFalseAnswers;

    private String translationDirection;
    private ResultSet data;


    public TaskDAO(int id){
        String sql = "select * from tasks where id = ('" + id + "') limit 1";
        readFromDB(sql);

    }

    private void readFromDB(String sql){
        this.data = read(sql);
        try {
            while (this.data.next()) {
                this.id = Integer.parseInt(data.getString("id"));
                this.typeTask = data.getString("type_task");
                this.question = data.getString("question");
                this.listTrueAnswers = data.getString("list_true_answers");
                this.listFalseAnswers = data.getString("list_false_answers");
                this.translationDirection = data.getString("translation_direction");
            }
        } catch (Exception ex) {
            log.error(ex);
        }
}

    public int getId() {
        return id;
    }

    public String getTypeTask() {
        return typeTask;
    }

    public String getQuestion() {
        return question;
    }

    public String getListTrueAnswers() {
        return listTrueAnswers;
    }
    public String getListFalseAnswers() {
        return listFalseAnswers;
    }

    public String getTranslationDirection() {
        return translationDirection;
    }
}

