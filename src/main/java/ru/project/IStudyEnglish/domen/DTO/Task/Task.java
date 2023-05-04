package ru.project.IStudyEnglish.domen.DTO.Task;

public abstract class Task {
    private String id;

    public abstract Task getTask(String id);
    public void setId(String id){
        this.id=id;
    }


}
