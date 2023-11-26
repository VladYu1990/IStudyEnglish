package ru.project.IStudyEnglish.NewModule.Application.task;

import ru.project.IStudyEnglish.NewModule.domain.Education.Student;
import ru.project.IStudyEnglish.NewModule.domain.Education.Task;
import ru.project.IStudyEnglish.NewModule.port.out.task.TaskDBPort;

import java.util.Collection;
import java.util.UUID;

public class TaskService implements TaskDBPort {

    @Override
    public Collection<Task> getByStudent(Student student, int limit) {
        //TODO
        return null;
    }

    @Override
    public Task getByUUID(UUID uuid) {
        //TODO
        return null;
    }

    @Override
    public void save(Collection<Task> taskCollection) {

    }

    @Override
    public void update(Collection<Task> taskCollection) {

    }

    @Override
    public void delete(Collection<Task> taskCollection) {

    }
}

