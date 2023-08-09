package ru.project.IStudyEnglish.dictionary_module.entity;

public class Word extends Source{

    private PartOfSpeech partOfSpeech;

    public Word(){

    }

    public Word(int id, String engTextStr, String rusTextStr, PartOfSpeech partOfSpeech) {
        this.id = id;
        this.engTextStr = engTextStr;
        this.rusTextStr = rusTextStr;
        this.partOfSpeech = partOfSpeech;
    }

    public Word(String engTextStr, String rusTextStr, PartOfSpeech partOfSpeech) {
        this.engTextStr = engTextStr;
        this.rusTextStr = rusTextStr;
        this.partOfSpeech = partOfSpeech;
    }

    public PartOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(PartOfSpeech partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }
}
