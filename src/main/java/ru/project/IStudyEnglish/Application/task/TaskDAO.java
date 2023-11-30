package ru.project.IStudyEnglish.Application.task;

import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.domain.Education.Task;
import ru.project.IStudyEnglish.port.out.task.TaskDBPort;

import java.time.Instant;
import java.util.Collection;
import java.util.UUID;

@Component
public class TaskDAO implements TaskDBPort {

    public Task getByUUID(UUID uuid) {
        return null;
    }


    public void save(Collection<Task> taskCollection, Instant instant) {

    }


    public void update(Collection<Task> taskCollection, Instant instant) {

    }

    @Override
    public void delete(Collection<Task> taskCollection, Instant instant) {

    }
}
