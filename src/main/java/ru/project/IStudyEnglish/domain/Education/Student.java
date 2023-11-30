package ru.project.IStudyEnglish.domain.Education;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.project.IStudyEnglish.domain.Autorisation.User;
import ru.project.IStudyEnglish.domain.Dictionary.Languages;
import ru.project.IStudyEnglish.domain.Dictionary.Rule;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
/**
 * Класс для разделения одного обучающегося от другого
 */
public class Student {
    /**
     * Уникальный код
     */
    private UUID uuid;
    /**
     * Уникальный user для студента
     */
    private UUID userUuid;
    /**
     * ФИО студента
     */
    private String userFullName;
    /**
     * Родной язык студента
     */
    private Languages nativeLanguages;
    /**
     * Изучаемый студентом язык
     */
    private Languages languagesForStudy;
    /**
     * Набор правил изученных студентом
     */
    private Collection<Rule> ruleCollection;
    /**
     * Дата создания студента
     */
    private Instant dateCreated;

    public static Student createStudent(User user, String fullName, Languages languageNative, Languages languagesForStudy, Instant dateCreated) {
        return
                Student.builder().
                        uuid(UUID.randomUUID()).
                        userUuid(user.getUuid()).
                        userFullName(fullName).
                        nativeLanguages(languageNative).
                        languagesForStudy(languagesForStudy).
                        ruleCollection(new ArrayList<>()).
                        dateCreated(dateCreated).
                        build();
    }


}
