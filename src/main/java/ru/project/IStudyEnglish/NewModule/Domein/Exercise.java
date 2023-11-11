package ru.project.IStudyEnglish.NewModule.Domein;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
/*
 * Класс для хранения упражнения, единого для всех обучающихся
 */
public class Exercise {

    /*
     * Уникальный идентификатор упражнения
     */
    private int id;
    /*
     * Слово/фраза, которую изучаем
     */
    private String question;
    /*
     * Значение/перевод этого слова/фразы
     */
    private String answer;
    /*
     * Пример использования слова/фразы
     */
    private String example;
    /*
     * Дата/время создания упражнения
     */
    private ZonedDateTime create;
    /*
     * Дата/время последнего обновления упражнения
     */
    private ZonedDateTime update;
}