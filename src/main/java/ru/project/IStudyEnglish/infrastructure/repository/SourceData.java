package ru.project.IStudyEnglish.infrastructure.repository;

public interface SourceData {


    SourceData WordDAO(String id);

    int getId();

    String getWriting();
    String getValue();
    String getLikeThis();

}
