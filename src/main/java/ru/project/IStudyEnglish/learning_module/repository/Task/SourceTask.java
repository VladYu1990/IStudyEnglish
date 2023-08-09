package ru.project.IStudyEnglish.learning_module.repository.Task;


import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;

import java.util.List;

@Component
public interface SourceTask {

    Task getOnId(int id);

    List<Task> getOnId(List<Integer> integerList);
    void create(Task task);

    void create(List<Task> list);

    void update(Task task);

    void update(List<Task> list);


}
