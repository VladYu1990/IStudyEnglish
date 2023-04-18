package ru.project.IStudyEnglish.infrastructure.DAO;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.infrastructure.ConnectDB;
import ru.project.IStudyEnglish.infrastructure.SourceTaskForRepetition;

import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
public class TaskForRepetitionDAO implements SourceTaskForRepetition {
    public String id;
    public String idSourceObject;
    public String typeSourceObject;
    public String typeRepetition;
    public String question;
    public String stringFalseListAnswers;
    public String idTrueAnswer;
    private String sql = "select * from tasksforrepetition  where id in ('";


    public TaskForRepetitionDAO(String id)  {

        try {
            ConnectDB conDB = new ConnectDB();
            ResultSet resultSet = conDB.getResultSet(sql + id + "') limit 1");

            while (resultSet.next()) {
                this.id = resultSet.getString("id");
                this.idSourceObject = resultSet.getString("idsourceobject");
                this.typeSourceObject = resultSet.getString("typesourceobject");
                this.typeRepetition = resultSet.getString("typerepetition");
                this.question = resultSet.getString("question");
                this.stringFalseListAnswers = resultSet.getString("stringfalselistanswers");
                this.idTrueAnswer = resultSet.getString("idtrueanswer");
            }

            resultSet.close();
        }
        catch (SQLException sqlException){
            log.error(sqlException);
        }




    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getIdSourceObject() {
        return idSourceObject;
    }

    @Override
    public String getTypeSourceObject() {
        return typeSourceObject;
    }

    @Override
    public String getTypeRepetition() {
        return typeRepetition;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getStringFalseListAnswers() {
        return stringFalseListAnswers;
    }

    @Override
    public String getIdTrueAnswer() {
        return idTrueAnswer;
    }
}
