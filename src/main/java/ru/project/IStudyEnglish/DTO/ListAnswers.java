package ru.project.IStudyEnglish.DTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ListAnswers {

    public List<String> list = new ArrayList<String>();
    public int number;


    public ListAnswers() throws SQLException {
        // сначала получаем верный ответ
        //потом подтягиваем по кодам 3 похожих
        // потом верный ответ в рандомное место
    }

    public ListAnswers(int idWordTrue,int idWord2,int idWord3,int idWord4) throws SQLException {


        this.list.add(Answer.getAnswer(idWord2));
        this.list.add(Answer.getAnswer(idWord3));
        this.list.add(Answer.getAnswer(idWord4));

        this.number = ThreadLocalRandom.current().nextInt(0,3);
        System.out.println(this.number);
        this.list.add(this.number,Answer.getAnswer(idWordTrue));
        System.out.println(this.list);


    }
}



