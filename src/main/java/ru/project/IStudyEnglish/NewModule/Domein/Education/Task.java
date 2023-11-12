package ru.project.IStudyEnglish.NewModule.Domein.Education;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
/*
 * Класс для хранения информации об изучении/обучении конкретным студентом конкретной фразы/слова и тд
 */
public class Task {
    /*
     * Связь с исходным упражнением
     */
    private Exercise exercise;
    /*
     * Уникальный код
     */
    private int id;
    /*
     * Идентификатор принадлежности задания студенту
     */
    private Student student;
    /*
     * Время, после которого можно повторить задание
     */
    private ZonedDateTime nextRepetition;
    /*
     * Время, когда последний раз повторяли задание
     */
    private ZonedDateTime lastRepetition;
    /*
     * Статус задания
     */
    private StatusOfTask status;
    /*
     * Количество верных ответов ПОДРЯД
     */
    private int countRightResponses;

    public Task(Exercise exercise, Student student){
        this.exercise = exercise;
        this.student= student;
        this.nextRepetition = ZonedDateTime.now();
        this.lastRepetition = ZonedDateTime.now();
        this.status = StatusOfTask.NOT_READY;
        this.countRightResponses = 0;
    }

    public void setCountRightResponses(int countRightResponses) {
        this.countRightResponses = countRightResponses;
        setStatusIfCountRightResponsesHasChanged();
    }

    public void updateIfAnswerIsTrue(ZonedDateTime zonedDateTime){
        setCountRightResponses(this.countRightResponses + 1);
        setLastRepetition(zonedDateTime);
        setNextRepetition(zonedDateTime.plusDays(this.countRightResponses*2));
    }

    public void updateIfAnswerIsFalse(ZonedDateTime zonedDateTime){
        setCountRightResponses(0);
        setLastRepetition(zonedDateTime);
        setNextRepetition(zonedDateTime.plusDays(1));
    }


    private void setStatusIfCountRightResponsesHasChanged(){
        if(status.equals(StatusOfTask.READY)){
            setStatus(StatusOfTask.STUDY);
        }
        if(this.countRightResponses > 7 || status.equals(StatusOfTask.STUDY)){
            setStatus(StatusOfTask.LEARNED);
        }
    }
}
