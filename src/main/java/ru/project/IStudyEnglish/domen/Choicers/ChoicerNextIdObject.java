package ru.project.IStudyEnglish.domen.Choicers;

import java.util.concurrent.ThreadLocalRandom;

public class ChoicerNextIdObject extends Choicer{


      public static String getNext(String User) {
        int number = ThreadLocalRandom.current().nextInt(1,100);//за выбор будет отвечать от
        String str = String.valueOf(number);
        return str;
    }
}
