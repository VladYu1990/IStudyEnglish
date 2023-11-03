package ru.project.IStudyEnglish.learning_module.service.Task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.entity.Source;
import ru.project.IStudyEnglish.dictionary_module.service.BuilderSource;
import ru.project.IStudyEnglish.learning_module.entity.Task.Task;
import ru.project.IStudyEnglish.learning_module.entity.Task.TranslationDirection;
import ru.project.IStudyEnglish.learning_module.entity.Task.TypeTask;
import ru.project.IStudyEnglish.learning_module.entity.TypeSource;
import ru.project.IStudyEnglish.learning_module.repository.Task.SourceTask;
import ru.project.IStudyEnglish.learning_module.service.Answer.BuilderAnswer;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope("prototype")
public class CreatorTask {
    //TODO добавить работу с артиклями, to и подобным


    private List<Source> sourceList = new ArrayList<>();
    private Source source;
    private List<Task> taskList = new ArrayList<>();
    private SourceTask sourceTask;

    private BuilderAnswer builderAnswer;
    private BuilderSource builderSource;

    @Autowired
    public CreatorTask(SourceTask sourceTask, BuilderAnswer builderAnswer, BuilderSource builderSource) {
        this.sourceTask = sourceTask;
        this.builderAnswer = builderAnswer;
        this.builderSource = builderSource;
    }

    public void create(Source source) {
        this.sourceList.add(source);
        cre1();
    }

    public void create(List<Source> sourceList) {
        this.sourceList = sourceList;
        cre1();
    }

    public void createAll(){
        this.sourceTask.truncate();
        this.sourceList.clear();
        this.sourceList.addAll(builderSource.getAll());
        cre1();
    }

    private void  cre1(){
        for (int i=0;i<this.sourceList.size();i++) {
            this.source = this.sourceList.get(i);
            cre();
        }
        sourceTask.save(this.taskList);
    }

    private void cre(){
        //TODO  в бд не хватает полей, приходится заполнять атрибуты хардкодом
        this.source.writing = true;
        this.source.typeSource = TypeSource.word;

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
