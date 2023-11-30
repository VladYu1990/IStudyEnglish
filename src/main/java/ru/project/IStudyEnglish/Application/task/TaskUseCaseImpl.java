package ru.project.IStudyEnglish.Application.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.domain.Education.Answer;
import ru.project.IStudyEnglish.domain.Education.Exercise;
import ru.project.IStudyEnglish.domain.Education.Student;
import ru.project.IStudyEnglish.domain.Education.Task;
import ru.project.IStudyEnglish.port.in.task.TaskUseCase;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Component
public class TaskUseCaseImpl implements TaskUseCase {

    private TaskConvertTaskDTO taskConvertTaskDTO;

    private TaskCreator taskCreator;

    private TaskDAO taskDAO;

    @Autowired
    public TaskUseCaseImpl(TaskConvertTaskDTO taskConvertTaskDTO, TaskCreator taskCreator, TaskDAO taskDAO) {
        this.taskConvertTaskDTO = taskConvertTaskDTO;
        this.taskCreator = taskCreator;
        this.taskDAO = taskDAO;
    }
    public void createTask(Student student, Exercise exercise,Instant instant){
        Collection<Exercise> exerciseList = new ArrayList<Exercise>();
        exerciseList.add(exercise);
        createTasks(student,exerciseList,instant);
    }

    public void createTasks(Student student, Collection<Exercise> exerciseList,Instant instant) {
        Collection<Task> taskCollection = new ArrayList<Task>();
        for(Exercise i:exerciseList){
            taskCollection.add(
                    taskCreator.create(
                            student.getUuid(),i.getUuid()));
        }
        taskDAO.save(taskCollection,instant);
    }
    public Task getByUUID(UUID taskUUID){
        return taskDAO.getByUUID(taskUUID);
    }
    public Task getNextTask(Student student,int amount) {
        //todo
        return null;
    }
    public Collection<Task> getNextTasks(Student student, int amount) {
        //todo
        return null;
    }
    public boolean checkTheAnswer(Task task, Answer answer, Instant instant) {
        task.getExerciseUUID();
        //todo
        //Exercise.getAnswer()==Answer.getByUUID(uuidAnswer).getValue;
        return false;
    }
    public void updateIfAnswerIsTrue(Task task, Instant instant) {
        task.updateIfAnswerIsTrue(instant);
    }

    public void updateIfAnswerIsFalse(Task task, Instant instant) {
        task.updateIfAnswerIsFalse(instant);
    }
    public void delete(Task task, Instant instant){
        Collection<Task> taskCollection = new ArrayList<Task>();
        taskCollection.add(task);
        deleteTasks(taskCollection,instant);
    }

    public void deleteTasks(Collection<Task> taskCollection, Instant instant){
        taskDAO.delete(taskCollection,instant);
    }


}
