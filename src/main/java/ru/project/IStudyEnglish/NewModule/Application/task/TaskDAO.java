package ru.project.IStudyEnglish.NewModule.Application.task;

import ru.project.IStudyEnglish.NewModule.domain.Education.Student;
import ru.project.IStudyEnglish.NewModule.domain.Education.Task;
import ru.project.IStudyEnglish.NewModule.port.out.task.TaskDBPort;

import java.util.Collection;
import java.util.UUID;

public class TaskDAO implements TaskDBPort {

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

    @Override
    public void delete(Collection<Task> taskCollection) {

    }
}
