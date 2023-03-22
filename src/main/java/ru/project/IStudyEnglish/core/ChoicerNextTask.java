package ru.project.IStudyEnglish.core;

import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.DTO.TaskForRepetition;

import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ChoicerNextTask {

    public String typeTopic;
    public String typeObject;
    public int idObject;



    public static TaskForRepetition genNextTask() {


        TaskForRepetition taskForRepetition = null;
        try {
            int numberNext = ChoicerNextTask.chouceNextObject();
            taskForRepetition = new TaskForRepetition("word",numberNext);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return taskForRepetition;
    }

    public static TaskForRepetition genNextTask(String typeObject, int id) {

        TaskForRepetition taskForRepetition = null;
        try {
            taskForRepetition = new TaskForRepetition(typeObject,id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return taskForRepetition;
    }
    //выбирает и тип учим/повторяем и тип объекта и id объекта
    public static int chouceNextObject(){
        int number = ThreadLocalRandom.current().nextInt(1,100);//за выбор будет отвечать от
        return number;
    }

}
