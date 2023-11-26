package ru.project.IStudyEnglish.NewModule.domain.Education;

/**
 * Статус дневной программы студента
 */
public enum StatusOfStudentDayProgram {
    /**
     * Программа создана, но не передана студенту
     */
    CREATED,
    /**
     * Программа передано студенту
     */
    IN_PROGRESS,
    /**
     * Программа полностью пройдена
     */
    DONE,
    /**
     * Программа пройдена частично
     */
    NOT_DONE
}
