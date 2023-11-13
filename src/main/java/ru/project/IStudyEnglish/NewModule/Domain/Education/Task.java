package ru.project.IStudyEnglish.NewModule.Domain.Education;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.DAYS;

@Getter
@Setter
@AllArgsConstructor
/*
 * Класс для хранения информации об изучении/обучении конкретным студентом конкретной фразы/слова и тд
 */
public class Task implements Comparable<Task> {
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
    private UUID uuidStudent;
    /*
     * Время, после которого можно повторить задание
     */
    private Instant nextRepetition;
    /*
     * Время, когда последний раз повторяли задание
     */
    private Instant lastRepetition;
    /*
     * Статус задания
     */
    private StatusOfTask status;
    /*
     * Количество верных ответов ПОДРЯД
     */
    private int countRightResponses;

    public Task(Exercise exercise, UUID uuidStudent, Instant dateTimeCreated) {
        this.exercise = exercise;
        this.uuidStudent = uuidStudent;
        this.nextRepetition = dateTimeCreated;
        this.lastRepetition = dateTimeCreated;
        this.status = StatusOfTask.NOT_READY;
        this.countRightResponses = 0;
    }

    public void setCountRightResponses(int countRightResponses) {
        this.countRightResponses = countRightResponses;
        setStatusIfCountRightResponsesHasChanged();
    }

    public void updateIfAnswerIsTrue(Instant instant) {
        setCountRightResponses(this.countRightResponses + 1);
        setLastRepetition(instant);
        setNextRepetition(instant.plus(this.countRightResponses * 2, DAYS));
    }

    public void updateIfAnswerIsFalse(Instant instant) {
        setCountRightResponses(0);
        setLastRepetition(instant);
        setNextRepetition(instant.plus(1, DAYS));
    }


    private void setStatusIfCountRightResponsesHasChanged() {
        if (status.equals(StatusOfTask.READY)) {
            setStatus(StatusOfTask.STUDY);
        }
        if (this.countRightResponses > 7 || status.equals(StatusOfTask.STUDY)) {
            setStatus(StatusOfTask.LEARNED);
        }
    }

    @Override
    public int compareTo(@NotNull Task o) {
        if (this.nextRepetition.isBefore(o.nextRepetition)) {
            return 1;
        } else {
            return -1;
        }
    }
}
