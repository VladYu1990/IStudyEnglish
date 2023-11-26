package ru.project.IStudyEnglish.NewModule.port.out.task;

import ru.project.IStudyEnglish.NewModule.domain.Education.Student;
import ru.project.IStudyEnglish.NewModule.domain.Education.Task;

import java.util.Collection;
import java.util.UUID;

public interface TaskDBPort {

    //запрос тасок из бд
    //получить пачку тасок
    Collection<Task> getByStudent(Student student,int limit);

    Task getByUUID(UUID uuid);

    void save(Collection<Task> taskCollection);

    void update(Collection<Task> taskCollection);

    void delete(Collection<Task> taskCollection);
}
