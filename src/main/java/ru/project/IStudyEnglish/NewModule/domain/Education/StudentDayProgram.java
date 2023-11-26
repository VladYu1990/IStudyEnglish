package ru.project.IStudyEnglish.NewModule.domain.Education;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.project.IStudyEnglish.NewModule.domain.StudentDayConfig;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Getter
@AllArgsConstructor
/**
 * Класс для хранения программы конкретного студента на конкретный день
 */
public class StudentDayProgram {
    /**
     * Уникальный код программы
     */
    private UUID uuid;
    /**
     * Код для связки с юзером
     */
    private UUID uuidStudent;
    /**
     * Дата, на которую создана программа
     */
    private Instant studyDate;
    /**
     * Статус программы
     */
    private StatusOfStudentDayProgram statusOfStudentDayProgram;
    /**
     * Список заданий студента в этой программе
     */
    private List<Task> taskList = new ArrayList<>();
    /**
     * Список ПРОЙДЕННЫХ заданий студента в этой программе
     */
    private List<UUID> taskUuidList = new ArrayList<>();


    public StudentDayProgram(UUID uuidStudent,Instant studyDate, List<Task> taskList) {
        this.uuid = UUID.randomUUID();
        this.uuidStudent = uuidStudent;
        this.studyDate = studyDate;
        this.statusOfStudentDayProgram = StatusOfStudentDayProgram.CREATED;
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
        //TODO
        this.taskList = tempTaskList.subList(0, StudentDayConfig.maxCountTaskForStudy);
    }

    public void addTask(Task task){
        this.taskList.add(task);
    }

    public void removeTask(Task task){
        this.taskList.remove(task);
    }

    public void countAnswerTask(Task task){
        taskUuidList.add(task.getUuid());
        setStatusOfStudentDayProgram();
    }

    public void close(){
        if (this.statusOfStudentDayProgram.equals(StatusOfStudentDayProgram.DONE)){
            //закрыть выполненную нельзя
        }
        else { this.statusOfStudentDayProgram = StatusOfStudentDayProgram.NOT_DONE;
        }
    }

    private void setStatusOfStudentDayProgram() {
        //программу в конечных статусах не апдейтим
        if (this.statusOfStudentDayProgram.equals(StatusOfStudentDayProgram.DONE) ||
        this.statusOfStudentDayProgram.equals(StatusOfStudentDayProgram.NOT_DONE)){
        }
        else {
            //все таски из программы пройдены
            if(taskList.size() == taskUuidList.size()){
                this.statusOfStudentDayProgram = StatusOfStudentDayProgram.DONE;
            //пошла работа
            } else if (taskUuidList.size()>0) {
                this.statusOfStudentDayProgram = StatusOfStudentDayProgram.IN_PROGRESS;
            }
        }
    }


}
