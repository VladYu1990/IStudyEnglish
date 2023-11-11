package ru.project.IStudyEnglish.NewModule.Domein;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
/*
 * Класс для хранения информации об изучении/обучении конретным студентом конкретной фразы/слова и тд
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
     * Ссылка на студента, которому принадлежит таска
     */
    private StudentDayProgram studentDayProgram;
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
    private StatusTask status;
    /*
     * Количество верных ответов ПОДРЯД
     */
    private int countRightResponses;

    public Task(Exercise exercise, StudentDayProgram studentDayProgram){
        this.exercise = exercise;
        this.studentDayProgram = studentDayProgram;
        this.nextRepetition = ZonedDateTime.now();
        this.lastRepetition = ZonedDateTime.now();
        this.status = StatusTask.NOT_READY;
        this.countRightResponses = 0;
    }

    public void setCountRightResponses(int countRightResponses) {
        this.countRightResponses = countRightResponses;
        setStatusIfCountRightResponsesHasChanged();
    }

    public void updateIfAnswerIsTrue(){
        setCountRightResponses(this.countRightResponses + 1);
        setLastRepetition(ZonedDateTime.now());

    }

    public void updateIfAnswerIsFalse(){
        setCountRightResponses(0);
        setLastRepetition(ZonedDateTime.now());
        setNextRepetition(ZonedDateTime.now().plusDays(this.countRightResponses*2));
    }


    private void setStatusIfCountRightResponsesHasChanged(){
        if(this.countRightResponses > 0 || status.equals(StatusTask.READY)){
            setStatus(StatusTask.STUDY);
        }
        if(this.countRightResponses > 7 || status.equals(StatusTask.STUDY)){
            setStatus(StatusTask.LEARNED);
        }
    }
}
