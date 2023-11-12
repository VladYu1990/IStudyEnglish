package ru.project.IStudyEnglish.NewModule.Domein.Education;


import lombok.Getter;
import ru.project.IStudyEnglish.NewModule.Domein.Autorisation.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
/*
 * Класс для создания программы конкретного студента на конкретный день
 */
public class BuilderStudentDayProgram {

    private User user;
    private LocalDate localDate;

    private StudentDayProgram studentDayProgram;

    public BuilderStudentDayProgram(User user, LocalDate localDate) {
        this.user = user;
        this.localDate = localDate;
        studentDayProgram = new StudentDayProgram(
                generateId(),
                this.user.getId(),
                localDate,
                generateTaskList()
        );
    }

    private String generateId(){
        return this.user + "/" + this.localDate.toString();
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
