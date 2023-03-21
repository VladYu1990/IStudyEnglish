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

        //выбирает и тип учим/повторяем и тип объекта и id объекта
        TaskForRepetition taskForRepetition = null;
        try {
            int number = ThreadLocalRandom.current().nextInt(1,100);
            taskForRepetition = new TaskForRepetition("word",number);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return taskForRepetition;
    }

}
