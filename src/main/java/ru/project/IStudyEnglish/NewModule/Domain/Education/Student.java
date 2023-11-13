package ru.project.IStudyEnglish.NewModule.Domain.Education;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
/*
 * Класс для разделения одного обучающегося от другого
 */
public class Student {
    /*
     * Уникальный код
     */
    private UUID uuid;
    /*
     * Уникальный user для студента
     */
    private UUID uuidUser;
    /*
     * ФИО студента
     */
    private String fio;
    /*
     * Список тасок находящихся сейчас на изучении у данного студента
     */
    private List<Task> taskListForStudy;

    public static Student createStudent(UUID uuidUser, String fio) {
        return new Student(UUID.randomUUID(),uuidUser,fio,new ArrayList<>());
    }

    public StudentDayProgram createStudentDayProgram(Instant studyDay){

        return StudentDayProgram.createStudentDayProgram(this.uuid,studyDay,this.taskListForStudy);
    }

    public void addTask(Task task){
        this.taskListForStudy.add(task);

    }

    public void removeTask(Task task){
        this.taskListForStudy.remove(task);
    }



}
