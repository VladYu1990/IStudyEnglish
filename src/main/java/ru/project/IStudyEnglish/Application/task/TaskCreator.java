package ru.project.IStudyEnglish.Application.task;

import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.domain.Education.Task;

import java.util.UUID;

@Component
public class TaskCreator {

    public Task create(UUID studentUUID, UUID exerciseUUID) {

        return Task.create(exerciseUUID,studentUUID);
    }
}
