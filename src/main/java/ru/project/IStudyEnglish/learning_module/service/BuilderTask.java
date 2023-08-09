package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.dictionary_module.entity.Word;
import ru.project.IStudyEnglish.learning_module.repository.Task.TaskDAO;
import ru.project.IStudyEnglish.learning_module.repository.Task.SourceTask;

import java.util.ArrayList;

@Component
public class BuilderTask {

    private Task task;
    private ArrayList<Task> listTask = new ArrayList<Task>();

    private SourceTask sourceTask;

    @Autowired
    public BuilderTask(SourceTask sourceTask) {

        this.sourceTask = sourceTask;

    }

    public Task getOnId(int id){
        sourceTask = new TaskDAO();
        task = sourceTask.getOnId(id);
        return task;
    }
//переделать на получение в листе родительского класса для источников
    public ArrayList<Task> getTask(ArrayList<Word> source){
        sourceTask = new TaskDAO();
        for (int i=0;i<source.size();i++){
            listTask.addAll(getTask("word",source.get(i).getId()));
        }

        return listTask;
    }

    public ArrayList<Task> getTask(String type, int idSource){
        type = "word";
        return sourceTask.getOnSource(idSource,type);
    }

    public Task get(String typeSource, int id) {

        return null;
    }


    public ArrayList<Task> getOnSource(Word word) {
        return null;
    }
}
