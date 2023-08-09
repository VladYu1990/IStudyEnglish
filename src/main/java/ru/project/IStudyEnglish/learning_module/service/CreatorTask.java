package ru.project.IStudyEnglish.learning_module.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.entity.Source;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.learning_module.entity.Task.TranslationDirection;
import ru.project.IStudyEnglish.learning_module.entity.Task.TypeTask;
import ru.project.IStudyEnglish.learning_module.repository.Task.SourceTask;
import ru.project.IStudyEnglish.learning_module.repository.Task.TaskDAO;

import java.util.ArrayList;
import java.util.List;


@Component
public class CreatorTask {

    private Source source;
    private List<Task> taskList = new ArrayList<>();
    private BuilderListAnswers builderListAnswers;
    private SourceTask sourceTask;

    @Autowired
    public CreatorTask(BuilderListAnswers builderListAnswers, SourceTask sourceTask) {
        this.builderListAnswers = builderListAnswers;
        this.sourceTask = sourceTask;
    }

    public void create(Source source){
        this.source = source;
        createdWriting();
        createdReading();
        createdHearing();
        createdSpeaking();
        sourceTask = new TaskDAO();
        sourceTask.create(taskList);

    }


    private void createdWriting(){
        if(this.source.writing == true) {
            createTask(TypeTask.writing,TranslationDirection.rus_eng, source.rusTextStr);
            createTask(TypeTask.writing,TranslationDirection.eng_rus, source.engTextStr);
        }
    }


    private void createdReading(){
        if(this.source.reading == true) {
            createTask(TypeTask.reading,TranslationDirection.rus_eng, source.rusTextStr);
        }
    }

    private void createdSpeaking(){
        if(this.source.speaking == true) {
            createTask(TypeTask.speaking,TranslationDirection.rus_eng, source.rusTextStr);
            createTask(TypeTask.speaking,TranslationDirection.eng_eng, source.engSoundStr);
        }
    }

    private void createdHearing(){
        if(this.source.hearing == true) {
            createTask(TypeTask.speaking,TranslationDirection.eng_rus, source.engSoundStr);
            createTask(TypeTask.speaking,TranslationDirection.eng_eng, source.engSoundStr);
        }
    }


    private void createTask(TypeTask typeTask, TranslationDirection dir,String question){
        Task task = new Task(typeTask,dir,question,this.source.idSource,this.source.typeSource);
        taskList.add(task);
    }
    


}
