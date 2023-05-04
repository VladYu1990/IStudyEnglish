package ru.project.IStudyEnglish.domen.DTO.Task.ForStudying;

import ru.project.IStudyEnglish.domen.DTO.Task.UserTask.UserTask;

public class TaskForLearning extends UserTask {

    public String id;
    public String idSource;
    public String typeSource;
    public String textTask;
    public String link;
    public String example;


    public TaskForLearning(String  id){
        this.id = id;

    }



}
