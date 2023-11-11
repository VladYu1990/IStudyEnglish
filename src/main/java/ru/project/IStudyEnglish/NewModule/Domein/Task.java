package ru.project.IStudyEnglish.NewModule.Domein;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/*
 * класс для хранения конкретного задания на обучения
 * своего рода задание из учебника, которое любой студент, допущенный к заданию может изучать
 */
public class Task {
    /*
     * уникальный идентификатор таски
     */
    private int id;
    /*
     * вопрос, на который нужно ответить в рамках изучения
     * для текстовых заданий текст
     * для аудио/визуальных ссылка на картинку или звук
     */
    private String question;
    /*
     * правильный ответ на вопрос
     * для текстовых заданий текст
     * для аудио/визуальных ссылка на картинку или звук
     */
    private String answer;
    /*
     * пример использования слова/фразы из вопроса
     */
    private String example;
    /*
     * дата создания таски
     * нужна, что служит для информации о периоде создания таски
     * и принадлежности к версии словаря на тот момент
     */
    private Time create;
    /*
     * дата апдейта таски
     * нужно, чтоб отслеживать обновляли ли таску после вноса изменений в исходную фразу/слово
     */
    private Time update;
}