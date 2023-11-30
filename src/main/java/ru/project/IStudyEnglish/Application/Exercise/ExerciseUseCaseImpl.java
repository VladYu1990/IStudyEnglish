package ru.project.IStudyEnglish.Application.Exercise;

import org.springframework.stereotype.Service;
import ru.project.IStudyEnglish.domain.Education.Exercise;

import java.util.UUID;

@Service
public class ExerciseUseCaseImpl {

    private BuilderExercise builderExercise;


    public Exercise get(UUID uuid){
        return builderExercise.get(uuid);
    }
}
