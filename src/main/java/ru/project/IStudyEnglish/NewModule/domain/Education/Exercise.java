package ru.project.IStudyEnglish.NewModule.domain.Education;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.project.IStudyEnglish.NewModule.domain.Dictionary.Rule;

import java.time.Instant;
import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
/**
 * Хранит упражнения, общее для всех обучающихся
 */
public class Exercise {

    /**
     * Уникальный идентификатор упражнения
     */
    private UUID uuid;
    /**
     * Тип упражнения
     */
    private TypeExercise typeExercise;
    /**
     * Тип источника для упражнения
     */
    private TypeSourceForExercise typeSource;
    /**
     * UUID источника
     */
    private UUID uuidSource;
    /**
     * Текст, что изучаем
     */
    private String question;
    /**
     * Правильный ответ на изучаемое упражнение
     */
    private String answer;
    /**
     * правила, которые необходимо знать, чтоб начать изучение данного упражнения
     */
    private Collection<Rule> ruleCollection;
    /**
     * Пример использования слова/фразы
     */
    private String example;
    /**
     * Дата/время создания упражнения
     */
    private Instant create;
    /**
     * Дата/время последнего обновления упражнения
     */
    private Instant update;

    public static Exercise create(TypeExercise typeExercise,String question, String answer,Collection<Rule> ruleCollection, String example, Instant create, Instant update) {
        return Exercise.builder().
                uuid(UUID.randomUUID()).
                typeExercise(typeExercise).
                question(question).
                answer(answer).
                ruleCollection(ruleCollection).
                example(example).
                create(create).
                update(update).
                    build();
    }
}