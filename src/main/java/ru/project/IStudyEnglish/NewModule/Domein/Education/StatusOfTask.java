package ru.project.IStudyEnglish.NewModule.Domein.Education;

/*
 * Класс для хранения статуса конкретной таски
 */
public enum StatusOfTask {
    /*
     * Задание еще рано изучать
     */
    NOT_READY,
    /*
     * Задание готово к изучению
     */
    READY,
    /*
     * Задание находится на стадии изучения
     */
    STUDY,
    /*
     * Задание изучено
     */
    LEARNED
}
