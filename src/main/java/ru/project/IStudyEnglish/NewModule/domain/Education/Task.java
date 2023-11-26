package ru.project.IStudyEnglish.NewModule.domain.Education;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.DAYS;

@Getter
@Setter
@AllArgsConstructor
@Builder
/**
 * Хранит информации об изучении/обучении конкретным студентом конкретной фразы/слова и тд
 */
public class Task implements Comparable<Task> {
    /**
     * Связь с исходным упражнением
     */
    private UUID exerciseUUID;
    /**
     * Уникальный код
     */
    private UUID uuid;
    /**
     * Идентификатор принадлежности задания студенту
     */
    private UUID uuidStudent;
    /**
     * Время, после которого можно повторить задание
     */
    private Instant nextRepetition;
    /**
     * Время, когда последний раз повторяли задание
     */
    private Instant lastRepetition;
    /**
     * Статус задания
     */
    private TaskStatus status;
    /**
     * Количество верных ответов ПОДРЯД, не отрицательное число
     */
    private int countRightResponses = 0;

    public static Task create(UUID exerciseUUID, UUID uuidStudent, Instant dateTimeCreated,TaskStatus taskStatus) {
        return Task.builder().
                uuid(UUID.randomUUID()).
                exerciseUUID(exerciseUUID).
                uuidStudent(uuidStudent).
                nextRepetition(dateTimeCreated).
                lastRepetition(dateTimeCreated).
                status(taskStatus).
                build();
    }

    public void setCountRightResponses(int countRightResponses) {
        this.countRightResponses = Integer.max(countRightResponses,0);
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
        if (status.equals(TaskStatus.READY)) {
            setStatus(TaskStatus.STUDY);
        }
        if (this.countRightResponses > 7 || status.equals(TaskStatus.STUDY)) {
            setStatus(TaskStatus.LEARNED);
        }
    }

    public void setStatus(TaskStatus status) {
        /*
        * Допустимо из вне получать только такой переход,
        * остальные переходы управляются логикой самой таски
         */
        if ( this.status.equals(TaskStatus.NOT_READY)||
                status.equals(TaskStatus.READY)) {
            this.status = status;
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
