package ru.project.IStudyEnglish.NewModule.Domain.Education;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

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
    private UUID uuid;
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
    private Instant create;
    /*
     * Дата/время последнего обновления упражнения
     */
    private Instant update;

    public Exercise(String question, String answer, String example, Instant create, Instant update) {
        this.uuid = UUID.randomUUID();
        this.question = question;
        this.answer = answer;
        this.example = example;
        this.create = create;
        this.update = update;
    }
}