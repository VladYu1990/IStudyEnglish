package ru.project.IStudyEnglish.domen.DTO.Questions;

public abstract class Question{
    private String value;
    private String linkOnSound;
    private String linkOnPicture;

    public Question() {

        value = "вопрос";
        linkOnPicture = "";
        linkOnSound = "";
    }
}
/*
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLinkOnSound() {
        return linkOnSound;
    }

    public void setLinkOnSound(String linkOnSound) {
        this.linkOnSound = linkOnSound;
    }

    public String getLinkOnPicture() {
        return linkOnPicture;
    }

    public void setLinkOnPicture(String linkOnPicture) {
        this.linkOnPicture = linkOnPicture;
    }
}
*/