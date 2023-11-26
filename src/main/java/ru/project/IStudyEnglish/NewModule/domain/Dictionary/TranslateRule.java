package ru.project.IStudyEnglish.NewModule.domain.Dictionary;

import java.util.Collection;
import java.util.UUID;

/**
 * Конкретное правило языка
 */
public class TranslateRule {
    /**
     * Код перевода
     */
    private UUID uuid;
    /**
     * Код правила
     */
    private UUID uuidRule;
    /**
     * Язык перевода правила
     */
    private Languages languages;
    /**
     * Текстовое описание правила
     */
    private String value;
    /**
     * Примеры для данного правила
     */
    private Collection<Example> exampleCollection;


}
