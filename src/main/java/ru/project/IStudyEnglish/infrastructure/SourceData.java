package ru.project.IStudyEnglish.infrastructure;

public interface SourceData {


    SourceData WordDAO(String id);

    int getId();

    String getWriting();
    String getValue();
    String getLikeThis();

}
