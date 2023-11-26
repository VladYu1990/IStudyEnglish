package ru.project.IStudyEnglish.NewModule.Application.task;

import ru.project.IStudyEnglish.NewModule.domain.Education.Task;

import java.time.Instant;
import java.util.UUID;

public class TaskCreator {

    public Task create(UUID studentUUID, UUID exerciseUUID) {

        return new Task(exerciseUUID,studentUUID, Instant.now());
    }
}
