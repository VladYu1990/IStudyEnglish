package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.UserTask.UserTask;

@Component
public class CreatorAnswersList {

    BuilderAnswersList builderAnswerList;

    public CreatorAnswersList() {}

    public CreatorAnswersList(UserTask userTask) {

        builderAnswerList.get(userTask.getTask().getTrueAnswer());
    }


}
