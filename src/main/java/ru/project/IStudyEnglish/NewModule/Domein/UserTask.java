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
<<<<<<< HEAD
/*
 * класс для хранения информации об изучении/обучении конретным студентом конкретной фразу/слову и тд
 */
public class UserTask{
    /*
     * связь с исходной таской, из нее берем вопрос и ответ,
     * а также при обновлении таски, мы фактически автоматически обновляем и задание
     * полезно, когда вносят правки в таску(ошиблись в написании и/или переводе, изменились правила и тд)
     */
    private Task task;
    /*
     * уникальный код, служит чтобы отделить одно задание от другого
     */
    private int id;
    /*
     * ссылка на студента, который выполняет задание
     * связка таска + студент = задание
     */
    private Student student;
    /*
     * время, после которого можно повторить задание
     * до достяжения этого времени задание не имеет смысла повторять
     */
    private Time nextRepetition;
    /*
     * время, когда последний раз повторяли задание,
     * если задание повторялось очень давно, стоит вместо повторения, сначала переобучить студента данному слову
     */
    private Time lastRepetition;
    /*
     * статус задания - описание статусов в объекте StatusUserTask
     */
    private StatusUserTask status;
    /*
     * количество верных ответов ПОДРЯД
     * при ошибке счетчик сбрасывается
     * это показатель влияет на переход задания в статус изучено и на кол-во дней между повторениями
     */
    private int countRightResponses;

    public UserTask(Task task,Student student){
        this.task = task;
        this.student = student;
        this.nextRepetition = new Time(System.currentTimeMillis());
        this.lastRepetition = new Time(System.currentTimeMillis());
        this.status = StatusUserTask.NOT_READY;
        this.countRightResponses = 0;

    }

    public void setCountRightResponses(int countRightResponses) {
        this.countRightResponses = countRightResponses;
        setStatusIfCountRightResponsesHasChanged();
=======
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
>>>>>>> origin/main
    }
    public void updateIfAnswerIsTrue(){
        setCountRightResponses(this.countRightResponses + 1);
        setLastRepetition(new Time(System.currentTimeMillis()));
<<<<<<< HEAD
        setNextRepetition(new Time(System.currentTimeMillis() + daysToMilliseconds(1)));
=======
        setNextRepetition(new Time(System.currentTimeMillis() + 1*24*60*60*1000));
>>>>>>> origin/main

    }

    public void updateIfAnswerIsFalse(){
        setCountRightResponses(0);
        setLastRepetition(new Time(System.currentTimeMillis()));
<<<<<<< HEAD
        setNextRepetition(new Time(System.currentTimeMillis() + daysToMilliseconds(this.countRightResponses)));
    }

    private long daysToMilliseconds(int countDays){
        return countDays*24*60*60*1000;
    }

    private void setStatusIfCountRightResponsesHasChanged(){
        if(this.countRightResponses > 0 || status.equals(StatusUserTask.READY)){
            setStatus(StatusUserTask.STUDY);
        }
        if(this.countRightResponses > 7 || status.equals(StatusUserTask.STUDY)){
            setStatus(StatusUserTask.LEARNED);
        }
=======
        setNextRepetition(new Time(
                System.currentTimeMillis() +
                        this.countRightResponses*24*60*60*1000));

>>>>>>> origin/main
    }
}
