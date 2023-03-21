package ru.project.IStudyEnglish.infrastructure;

import java.sql.SQLException;

public interface SourceData {
    String getData();
    String getData(int id) throws SQLException;
    String getDataNext();

    int getId();

    String getWriting();

    String getLikeThisWord();

    String getValue();
}
