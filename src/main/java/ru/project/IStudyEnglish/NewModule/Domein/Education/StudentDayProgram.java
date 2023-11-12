package ru.project.IStudyEnglish.NewModule.Domein.Education;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
/*
 * Класс для хранения программы конкретного студента на конкретный день
 */

public class StudentDayProgram {
    /*
     * Уникальный код программы
     */
    private String id;
    /*
     * Код для связки с юзером
     */
    private Student student;
    /*
     * Дата, на которую создана программа
     */
    private LocalDate date;
    /*
     * Список заданий студента в этой программе
     */
    private List<Task> taskList = new ArrayList<>();




}
