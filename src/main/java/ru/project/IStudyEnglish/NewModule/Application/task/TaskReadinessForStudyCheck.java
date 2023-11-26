package ru.project.IStudyEnglish.NewModule.Application.task;

import ru.project.IStudyEnglish.NewModule.Application.Exercise.ExerciseUseCaseImpl;
import ru.project.IStudyEnglish.NewModule.domain.Dictionary.Rule;
import ru.project.IStudyEnglish.NewModule.domain.Education.Exercise;
import ru.project.IStudyEnglish.NewModule.domain.Education.Student;
import ru.project.IStudyEnglish.NewModule.domain.Education.Task;
import ru.project.IStudyEnglish.NewModule.domain.Education.TaskStatus;

import java.util.ArrayList;
import java.util.List;

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
