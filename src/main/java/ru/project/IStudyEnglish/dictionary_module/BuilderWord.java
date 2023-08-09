package ru.project.IStudyEnglish.dictionary_module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.User.User;
import ru.project.IStudyEnglish.dictionary_module.entity.Word;
import ru.project.IStudyEnglish.dictionary_module.repository.WordDAO;
import ru.project.IStudyEnglish.dictionary_module.repository.SourceWord;

@Component
public class BuilderWord {

    private SourceWord sourceWord;//как источник данных для UserTaskController

    public BuilderWord() {
    }
    @Autowired
    public BuilderWord(WordDAO wordDAO) {
        this.sourceWord = wordDAO;
    }

    public Word getOnId(int id) {

        return sourceWord.getOnId(id);
    }

    public Word create(User user){
        //TODO
        return null;
    }

    public Word getOnUser(User user){
        //TODO
        return null;
    }

}
