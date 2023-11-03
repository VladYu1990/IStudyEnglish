package ru.project.IStudyEnglish.learning_module.repository.Task;


import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.dictionary_module.entity.TypeSource;

import java.util.List;

@Component
public interface SourceTask {

    Task get(int id);

    List<Task> get(List<Integer> integerList);
    void save(Task task);

    void save
            (List<Task> list);

    void update(Task task);

    void update(List<Task> list);

    List<Task> get(TypeSource typeSource, int id);

    void truncate();

    List<Task> getAll();
}
