package ru.project.IStudyEnglish.learning_module.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.entity.Source;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.learning_module.entity.Task.TranslationDirection;
import ru.project.IStudyEnglish.learning_module.entity.Task.TypeTask;
import ru.project.IStudyEnglish.learning_module.entity.TypeSource;
import ru.project.IStudyEnglish.learning_module.repository.Task.SourceTask;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope("prototype")
public class CreatorTask {
    //TODO добавить работу с артиклями, to и подобным
    private Source source;
    private List<Task> taskList = new ArrayList<>();
    private SourceTask sourceTask;

    private BuilderAnswer builderAnswer;

    @Autowired
    public CreatorTask(Source source, SourceTask sourceTask,  BuilderAnswer builderAnswer) {
        this.source = source;
        this.sourceTask = sourceTask;
        this.builderAnswer = builderAnswer;
    }

    public void create(Source source) {
        List<Source> sourceList = new ArrayList<>();
        sourceList.add(source);
        create(sourceList);
    }

    public void create(List<Source> sourceList) {
        for (int i=0;i<sourceList.size();i++) {
            this.source = sourceList.get(i);
            cre();
        }
        sourceTask.save(taskList);
    }

    private void cre(){
        source.writing = true;
        source.reading = true;
        source.typeSource = TypeSource.word;

        createWriting();
        createReading();
        createHearing();
        createSpeaking();
    }
    private void createWriting(){
        if(this.source.writing == true) {
            createTask(TypeTask.writing,TranslationDirection.rus_eng, source.rusTextStr,source.engTextStr);
            createTask(TypeTask.writing,TranslationDirection.eng_rus, source.engTextStr,source.rusTextStr);
        }
    }

    private void createReading(){
        if(this.source.reading == true) {
            createTask(TypeTask.reading,TranslationDirection.rus_eng, source.rusTextStr,source.engTextStr);
        }
    }

    private void createSpeaking(){
        if(this.source.speaking == true) {
            createTask(TypeTask.speaking,TranslationDirection.rus_eng, source.rusTextStr,source.engTextStr);
            createTask(TypeTask.speaking,TranslationDirection.eng_eng, source.engTextStr,source.engTextStr);
        }
    }

    private void createHearing(){
        if(this.source.hearing == true) {
            createTask(TypeTask.hearing,TranslationDirection.eng_rus, source.engSoundStr,source.rusTextStr);
            createTask(TypeTask.hearing,TranslationDirection.eng_eng, source.engSoundStr,source.engTextStr);
        }
    }


    private void createTask(TypeTask typeTask, TranslationDirection dir,String question,String answer){
        Task task = new Task(typeTask,dir,question, builderAnswer.get(answer).getId(),this.source);
        this.taskList.add(task);
    }



}
