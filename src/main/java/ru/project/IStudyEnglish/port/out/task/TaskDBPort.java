package ru.project.IStudyEnglish.port.out.task;

import ru.project.IStudyEnglish.domain.Education.Task;

import java.time.Instant;
import java.util.Collection;
import java.util.UUID;

public interface TaskDBPort {

    Task getByUUID(UUID uuid);

    void save(Collection<Task> taskCollection, Instant instant);

    void update(Collection<Task> taskCollection, Instant instant);

    void delete(Collection<Task> taskCollection, Instant instant);
}
