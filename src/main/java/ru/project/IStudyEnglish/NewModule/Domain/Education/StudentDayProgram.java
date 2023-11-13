package ru.project.IStudyEnglish.NewModule.Domain.Education;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


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
    private UUID uuid;
    /*
     * Код для связки с юзером
     */
    private UUID uuidStudent;
    /*
     * Дата, на которую создана программа
     */
    private Instant studyDate;
    /*
     * Список заданий студента в этой программе
     */
    private List<Task> taskList = new ArrayList<>();
    /*
     * Максимальное число заданий в программе
     */
    private final int maxCountTaskForStudy = 10;

    public StudentDayProgram(UUID uuidStudent,Instant studyDate, List<Task> taskList) {
        this.uuid = UUID.randomUUID();
        this.uuidStudent = uuidStudent;
        this.studyDate = studyDate;
        generateTaskList(taskList);
    }

    public static StudentDayProgram createStudentDayProgram(UUID uuidStudent, Instant studyDate, List<Task> taskList){
        return new StudentDayProgram(uuidStudent,studyDate,taskList);
    }

    private void generateTaskList(List<Task> taskList) {
        List<Task> tempTaskList = new ArrayList<>();
        for (int i = 0;i<taskList.size();i++){
            if (taskList.get(i).getNextRepetition().isBefore(Instant.now())){
                tempTaskList.add(taskList.get(i));
            }
        }
        Collections.sort(tempTaskList);
        this.taskList = tempTaskList.subList(0, maxCountTaskForStudy);
    }

    public void addTask(Task task){
        this.taskList.add(task);
    }

    public void removeTask(Task task){
        this.taskList.remove(task);
    }


}
