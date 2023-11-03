package ru.project.IStudyEnglish.learning_module.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.service.BuilderSource;
import ru.project.IStudyEnglish.learning_module.entity.TypeSource;
import ru.project.IStudyEnglish.learning_module.service.Answer.BuilderAnswer;
import ru.project.IStudyEnglish.learning_module.service.Task.BuilderTask;
import ru.project.IStudyEnglish.learning_module.service.CreatorAnswer;
import ru.project.IStudyEnglish.learning_module.service.Task.CreatorTask;

@Component
public class ControllerHandler {


    private BuilderTask builderTask;

    private CreatorTask creatorTask;

    private BuilderSource builderSource;

    private BuilderAnswer builderAnswer;

    private CreatorAnswer creatorAnswer;

    public ControllerHandler() {
    }

    @Autowired
    public ControllerHandler(BuilderTask builderTask, CreatorTask creatorTask, BuilderSource builderSource, BuilderAnswer builderAnswer, CreatorAnswer creatorAnswer) {
        this.builderTask = builderTask;
        this.creatorTask = creatorTask;
        this.builderSource = builderSource;
        this.builderAnswer = builderAnswer;
        this.creatorAnswer = creatorAnswer;
    }

    public void taskCreate(String token, String sourceStr, int idSource){
        creatorTask.create(builderSource.get(sourceStr,idSource));
    }

    public void taskCreate(String token,String sourceStr){

        creatorTask.create(builderSource.get(TypeSource.word));
    }

    public void taskCreate(String token){

        creatorTask.createAll();
    }


    public void answerCreate(String token,String sourceStr, int idSource){
        creatorAnswer.create(builderSource.get(sourceStr,idSource));
    }

    public void  answerCreate(){
        creatorAnswer.create(builderSource.getAll());
    }
}
