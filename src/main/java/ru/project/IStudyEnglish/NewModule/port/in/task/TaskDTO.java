package ru.project.IStudyEnglish.NewModule.port.in.task;

import org.springframework.stereotype.Repository;
import ru.project.IStudyEnglish.NewModule.domain.Education.Student;
import ru.project.IStudyEnglish.NewModule.domain.Education.Task;
import ru.project.IStudyEnglish.NewModule.port.out.task.TaskDBPort;

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

    public void save(Collection<Task> taskCollection) {
    }

    public void update(Collection<Task> taskCollection) {

    }

    public void delete(Collection<Task> taskCollection) {

    }
}
