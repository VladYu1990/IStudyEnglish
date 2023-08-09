package ru.project.IStudyEnglish.dictionary_module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.entity.Word;
import ru.project.IStudyEnglish.dictionary_module.repository.SourceWord;
import ru.project.IStudyEnglish.dictionary_module.repository.WordDAO;
import ru.project.IStudyEnglish.user_module.entity.User.User;

import java.util.List;

@Component
public class BuilderWord {

    private SourceWord sourceWord;//как источник данных для UserTaskController

    public BuilderWord() {
    }
    @Autowired
    public BuilderWord(WordDAO wordDAO) {
        this.sourceWord = wordDAO;
    }

    public Word get(int id) {

        return sourceWord.get(id);
    }

    public Word create(User user){
        //TODO
        return null;
    }

    public Word get(User user){
        //TODO
        return null;
    }

    public List<Word> get() {
        List<Word> list = sourceWord.get();
        return list;
    }
}
