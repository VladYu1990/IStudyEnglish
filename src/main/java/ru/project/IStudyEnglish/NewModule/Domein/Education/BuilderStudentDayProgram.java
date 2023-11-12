package ru.project.IStudyEnglish.NewModule.Domein.Education;


import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
/*
 * Класс для создания программы конкретного студента на конкретный день
 */
public class BuilderStudentDayProgram {

    private Student student;
    private LocalDate localDate;

    private StudentDayProgram studentDayProgram;

    public BuilderStudentDayProgram(Student student, LocalDate localDate) {
        this.student = student;
        this.localDate = localDate;
        studentDayProgram = new StudentDayProgram(
                generateId(),
                this.student.getId(),
                localDate,
                generateTaskList()
        );
    }

    private String generateId(){
        return this.student + "/" + this.localDate.toString();
    }

    private List<Task> generateTaskList() {
        List<Task> taskList = new ArrayList<>();
        //TODO
        //берет все таски юзера
        //смотрит какие можно повторить
        //сортирует их по NextRepetition DESC
        //выбирает N штук и записывает в this.taskList
        return taskList;
    }

}
