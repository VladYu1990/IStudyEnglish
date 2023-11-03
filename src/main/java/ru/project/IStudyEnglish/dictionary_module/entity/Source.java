package ru.project.IStudyEnglish.dictionary_module.entity;

import org.springframework.stereotype.Component;

@Component
public class Source {

    public TypeSource typeSource;

    public int id;

    public String rusTextStr;
    public String engTextStr;

    public boolean writing;
    public boolean reading;

    public String rusSoundStr;
    public String engSoundStr;

    public boolean speaking;
    public boolean hearing;

    public String picturesStr;

    public TypeSource getTypeSource() {
        return typeSource;
    }

    public void setTypeSource(TypeSource typeSource) {
        this.typeSource = typeSource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRusTextStr() {
        return rusTextStr;
    }

    public void setRusTextStr(String rusTextStr) {
        this.rusTextStr = rusTextStr;
    }

    public String getEngTextStr() {
        return engTextStr;
    }

    public void setEngTextStr(String engTextStr) {
        this.engTextStr = engTextStr;
    }

    public boolean isWriting() {
        return writing;
    }

    public void setWriting(boolean writing) {
        this.writing = writing;
    }

    public boolean isReading() {
        return reading;
    }

    public void setReading(boolean reading) {
        this.reading = reading;
    }

    public String getRusSoundStr() {
        return rusSoundStr;
    }

    public void setRusSoundStr(String rusSoundStr) {
        this.rusSoundStr = rusSoundStr;
    }

    public String getEngSoundStr() {
        return engSoundStr;
    }

    public void setEngSoundStr(String engSoundStr) {
        this.engSoundStr = engSoundStr;
    }

    public boolean isSpeaking() {
        return speaking;
    }

    public void setSpeaking(boolean speaking) {
        this.speaking = speaking;
    }

    public boolean isHearing() {
        return hearing;
    }

    public void setHearing(boolean hearing) {
        this.hearing = hearing;
    }

    public String getPicturesStr() {
        return picturesStr;
    }

    public void setPicturesStr(String picturesStr) {
        this.picturesStr = picturesStr;
    }
}
