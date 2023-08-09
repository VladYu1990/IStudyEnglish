package ru.project.IStudyEnglish.learning_module.repository.Answer;

import ru.project.IStudyEnglish.learning_module.entity.Answer.Answer;

public interface SourceAnswer {

    public Answer getOnId(int idAnswer);

    public Answer getOnValue(String value);

    void create(String value);
}
