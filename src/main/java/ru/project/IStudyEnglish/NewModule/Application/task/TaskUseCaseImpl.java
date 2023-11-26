package ru.project.IStudyEnglish.NewModule.Application.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.NewModule.domain.Education.Student;
import ru.project.IStudyEnglish.NewModule.domain.Education.StudentDayProgram;
import ru.project.IStudyEnglish.NewModule.domain.Education.Task;
import ru.project.IStudyEnglish.NewModule.port.in.task.TaskUseCase;


import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Component
public class TaskUseCaseImpl implements TaskUseCase {

    private TaskConvertTaskDTO taskConvertTaskDTO;

    private TaskCreator taskCreator;

    private TaskDAO taskDAO;




    private Collection<Task> taskCollection = new ArrayList<>();

    @Autowired
    public TaskUseCaseImpl(){
    }


    public void createTask(UUID studentUUID, UUID exerciseUUID){
        Task task = taskCreator.create(studentUUID,exerciseUUID);
        this.taskCollection.clear();
        this.taskCollection.add(task);
        saveTaskList();
    }

    public void createTaskList(UUID studentUUID,Collection<UUID> exerciseUUIDList) {
        this.taskCollection.clear();
        for(UUID i:exerciseUUIDList){
            this.taskCollection.add(
                    taskCreator.create(
                            studentUUID,i));
        }
        saveTaskList();
    }

    private void saveTaskList() {
        taskDTO.save(this.taskCollection);
    }


    public TaskDTO getByUUID(UUID taskUUID){
        Task task = Task.(taskUUID);
        return taskConvertTaskDTO.convert(task);
    }
    public StudentDayProgram getStudentDayProgram(Student student, Instant data){
        return StudentDayProgram;
    }
    public void responseAnswer(UUID taskUUID,UUID uuidAnswer){}

    public void delete(UUID taskUUID){}


}
