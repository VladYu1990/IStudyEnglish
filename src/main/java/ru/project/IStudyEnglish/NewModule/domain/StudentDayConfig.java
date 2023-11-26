package ru.project.IStudyEnglish.NewModule.domain;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
/**
 * Конфигурация для StudentDayProgram
 */
public class StudentDayConfig {

    @Value("10")
    /**
     * Максимальное кол-во тасок в одной программе
     */
    public static int maxCountTaskForStudy;
}
