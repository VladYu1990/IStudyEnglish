package ru.project.IStudyEnglish.NewModule.Domein;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTask extends Task{
    int id;
    private Student student;
    private Time nextRepetition;
    private Time lastRepetition;
    private StatusUserTask status;
    private int countRightResponses;

    public void setCountRightResponses(int countRightResponses) {
        this.countRightResponses = countRightResponses;
        if(this.countRightResponses > 7 || status.equals(StatusUserTask.study)){
            setStatus(StatusUserTask.learned);
        }
    }
    public void updateIfAnswerIsTrue(){
        setCountRightResponses(this.countRightResponses + 1);
        setLastRepetition(new Time(System.currentTimeMillis()));
        setNextRepetition(new Time(System.currentTimeMillis() + 1*24*60*60*1000));

    }

    public void updateIfAnswerIsFalse(){
        setCountRightResponses(0);
        setLastRepetition(new Time(System.currentTimeMillis()));
        setNextRepetition(new Time(
                System.currentTimeMillis() +
                        this.countRightResponses*24*60*60*1000));

    }
}
