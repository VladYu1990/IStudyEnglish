package ru.project.IStudyEnglish.dictionary_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.TypeSource;


@Component
public class CreatorSource {

    CreatorWord creatorWord;

    @Autowired
    public CreatorSource(CreatorWord creatorWord) {
        this.creatorWord = creatorWord;
    }

    public CreatorSource(TypeSource typeSource, int id) {
        if(typeSource.equals("word")){
            creatorWord.wordDAO.get();
        }
    }
}
