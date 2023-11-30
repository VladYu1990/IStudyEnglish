package ru.project.IStudyEnglish.Application.task;

import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.Application.Exercise.ExerciseUseCaseImpl;
import ru.project.IStudyEnglish.domain.Dictionary.Rule;
import ru.project.IStudyEnglish.domain.Education.Exercise;
import ru.project.IStudyEnglish.domain.Education.Student;
import ru.project.IStudyEnglish.domain.Education.Task;
import ru.project.IStudyEnglish.domain.Education.TaskStatus;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskReadinessForStudyCheck {

    private ExerciseUseCaseImpl exerciseUseCaseImpl;


    private TaskStatus readyToStudyCheckInterior(Student student, Exercise exercise){
        List<Rule> ruleListExercise = new ArrayList<Rule>(exercise.getRuleCollection());
        List<Rule> ruleListStudent = new ArrayList<Rule>(student.getRuleCollection());
        for(Rule rule:ruleListStudent){
            ruleListExercise.remove(rule);
        }

        if (ruleListExercise.isEmpty()){
            return TaskStatus.READY;
        }
        else {
            return TaskStatus.NOT_READY;
        }
    }

    public TaskStatus readyToStudyCheck(Student student, Task task){
        return readyToStudyCheckInterior(student, exerciseUseCaseImpl.get(task.getExerciseUUID()));
    }
}
