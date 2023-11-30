package ru.project.IStudyEnglish.domain.Education;

/**
 * Статус конкретной таски
 */
public enum TaskStatus {
    /**
     * Задание еще рано изучать
     */
    NOT_READY,
    /**
     * Задание готово к изучению
     */
    READY,
    /**
     * Задание находится на стадии изучения
     */
    STUDY,
    /**
     * Задание изучено
     */
    LEARNED
}
