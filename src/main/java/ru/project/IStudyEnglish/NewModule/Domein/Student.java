package ru.project.IStudyEnglish.NewModule.Domein;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/*
 * класс для хранения информации об обучающихся
 */

public class Student {
    /*
     * уникальный код студента, нужен для отделения 1 студента от другого
     */
    int id;
    /*
     * кол-во выученных заданий студентом
     */
    int countLearnedUserTask;
    /*
     * кол-во заданий на обучении
     */
    int countStudyUserTask;
    /*
     * кол-во заданий доступных пользователю
     */
    int countUserTask;
}
