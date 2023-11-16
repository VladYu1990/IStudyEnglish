package ru.project.IStudyEnglish.NewModule.Domain.Education;

public enum StatusOfStudentDayProgram {
    /*
     * программа создана, но не передана студенту
     */
    CREATED,
    /*
     * Программа передано студенту
     */
    IN_PROGRESS,
    /*
     * Программа полностью пройдена
     */
    DONE,
    /*
     * Программа пройдена частично
     */
    NOT_DONE
}
