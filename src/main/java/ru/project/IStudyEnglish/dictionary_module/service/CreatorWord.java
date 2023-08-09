package ru.project.IStudyEnglish.dictionary_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.entity.PartOfSpeech;
import ru.project.IStudyEnglish.dictionary_module.entity.Word;
import ru.project.IStudyEnglish.dictionary_module.repository.WordDAO;

@Component
public class CreatorWord {

    public WordDAO wordDAO;

    @Autowired
    public CreatorWord(WordDAO wordDAO) {
        this.wordDAO = wordDAO;
    }

    public void create(String rusText, String engText, PartOfSpeech partOfSpeech){
        Word word = new Word(engText,rusText,partOfSpeech);
        wordDAO.save(word);
    }
}
