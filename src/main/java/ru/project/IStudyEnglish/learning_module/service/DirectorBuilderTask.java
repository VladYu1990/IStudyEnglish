package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.learning_module.repository.Task.SourceTask;

@Component
public class DirectorBuilderTask {

    private SourceTask sourceTask;

    @Autowired
    public DirectorBuilderTask(SourceTask sourceTask) {
        this.sourceTask = sourceTask;
    }

    public Task getOnId(int id){

        return sourceTask.getOnId(id);
    }

    public Task getOnToken(){
        return  null;
    }
}
