package ru.project.IStudyEnglish.dictionary_module.entity;

public class Word extends Source{

    private int id;
    private String valueENG;
    private String valueRUS;

    private int code_of_part_speech;

    public Word(){

    }

    public Word(int id, String valueENG, String valueRUS, int code_of_part_speech) {
        this.id = id;
        this.valueENG = valueENG;
        this.valueRUS = valueRUS;
        this.code_of_part_speech = code_of_part_speech;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValueENG() {
        return this.valueENG;
    }

    public void setValueENG(String valueENG) {
        this.valueENG = valueENG;
    }

    public String getValueRUS() {
        return valueRUS;
    }

    public void setValueRUS(String valueRUS) {
        this.valueRUS = valueRUS;
    }

    public int getCode_of_part_speech() {
        return code_of_part_speech;
    }

    public void setCode_of_part_speech(int code_of_part_speech) {
        this.code_of_part_speech = code_of_part_speech;
    }
}
