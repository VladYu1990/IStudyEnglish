package ru.project.IStudyEnglish.learning_module.service.Answer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.entity.Source;
import ru.project.IStudyEnglish.learning_module.entity.Answer.Answer;
import ru.project.IStudyEnglish.learning_module.entity.Answer.TypeAnswer;
import ru.project.IStudyEnglish.learning_module.repository.Answer.AnswersDAO;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class CreatorAnswer {

    Source source;

    List<Answer> answersList = new ArrayList<>();

    AnswersDAO answersDAO;


    @Autowired
    public CreatorAnswer(AnswersDAO answersDAO) {
        this.answersDAO = answersDAO;
    }


    public void create(Source source) {
        this.answersList.clear();
        cre(source);
        save();
    }

    public void create(List<Source> sourceList) {
        this.answersList.clear();
        for (int i = 0; i < sourceList.size(); i++) {
            cre(sourceList.get(i));
        }
        save();
    }

    private void cre(Source source) {
        this.source = source;
        createdRusText();
        createdEngText();
        createRusSound();
        createRusSound();
    }


    private void createdRusText() {
        if (this.source.rusTextStr != null) {
            answersList.add(new Answer(0, source.rusTextStr, TypeAnswer.textRus));
        }
    }

    private void createdEngText() {
        if (this.source.engTextStr != null) {
            answersList.add(new Answer(0, source.engTextStr, TypeAnswer.textEng));
        }
    }

    private void createRusSound () {
        if (this.source.rusSoundStr != null) {
        answersList.add(new Answer(0, source.rusSoundStr, TypeAnswer.linkSoundRus));
        }
    }

    private void createEngSound() {
        if (this.source.engSoundStr != null) {
            answersList.add(new Answer(0, source.engSoundStr, TypeAnswer.linkSoundEng));
        }
    }

    private void save(){
        answersDAO.create(this.answersList);
    }

}

