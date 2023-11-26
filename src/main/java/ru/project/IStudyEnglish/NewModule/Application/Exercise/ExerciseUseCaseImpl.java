package ru.project.IStudyEnglish.NewModule.Application.Exercise;

import ru.project.IStudyEnglish.NewModule.domain.Education.Exercise;

import java.util.UUID;

public class ExerciseUseCaseImpl {

    private BuilderExercise builderExercise;


    public Exercise get(UUID uuid){
        return builderExercise.get(uuid);
    }
}
