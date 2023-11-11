package ru.project.IStudyEnglish.NewModule.Domein;

/*
 * Класс для хранения статуса конкретной таски
 */
public enum StatusTask {
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
