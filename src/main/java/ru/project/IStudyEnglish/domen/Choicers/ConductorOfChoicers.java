package ru.project.IStudyEnglish.domen.Choicers;

public class ConductorOfChoicers {

    private String typeTask;//
    private String typeObject;
    private String typeRepetition;
    private String idObject;


    public ConductorOfChoicers(String user){
        this.typeTask = ChoicerNextTypeTopic.getNext(user);
        this.typeObject = ChoicerNextTypeObject.getNext(user);
        this.typeRepetition = ChoicerNextTypeRepetition.getNext(user);
        this.idObject = ChoicerNextIdObject.getNext(user);

    }

    public String getTypeTask() {
        return typeTask;
    }

    public String getTypeObject() {
        return typeObject;
    }

    public String getTypeRepetition() {
        return typeRepetition;
    }

    public String getIdObject() {
        return idObject;
    }
}
