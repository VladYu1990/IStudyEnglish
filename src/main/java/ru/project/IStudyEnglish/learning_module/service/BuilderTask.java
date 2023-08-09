package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.entity.Source;
import ru.project.IStudyEnglish.dictionary_module.entity.Word;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.learning_module.repository.Task.TaskDAO;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuilderTask {

    private Task task;
    private ArrayList<Task> listTask = new ArrayList<Task>();

    private TaskDAO taskDAO;

    @Autowired
    public BuilderTask(TaskDAO taskDAO) {

        this.taskDAO = taskDAO;

    }

    public Task get(int id){
        task = taskDAO.get(id);
        return task;
    }


    public List<Task> get(Source source) {
        return taskDAO.get(source.getTypeSource(),source.getId());
    }

    public List<Task> get(List<Source> sourceList){
        List<Task> taskList = new ArrayList<Task>();
        for (int i = 0;i<sourceList.size();i++){
            taskList.addAll(get(sourceList.get(i)));
        }
        return taskList;
    }


    public ArrayList<Task> getOnSource(Word word) {
        return null;
    }
}
