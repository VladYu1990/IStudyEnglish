package ru.project.IStudyEnglish.port.in.task;

import org.springframework.stereotype.Repository;
import ru.project.IStudyEnglish.domain.Education.Student;
import ru.project.IStudyEnglish.domain.Education.Task;
import ru.project.IStudyEnglish.port.out.task.TaskDBPort;

import java.time.Instant;
import java.util.Collection;
import java.util.UUID;

@Repository
public class TaskDTO implements TaskDBPort {


    public Collection<Task> getByStudent(Student student, int limit) {
        return null;
    }

    public Task getByUUID(UUID uuid) {
        return null;
    }

    public void save(Collection<Task> taskCollection, Instant instant) {
    }

    public void update(Collection<Task> taskCollection, Instant instant) {

    }

    public void delete(Collection<Task> taskCollection, Instant instant) {

    }
}
