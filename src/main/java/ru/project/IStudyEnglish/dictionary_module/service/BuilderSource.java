package ru.project.IStudyEnglish.dictionary_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.BuilderWord;
import ru.project.IStudyEnglish.dictionary_module.entity.Source;
import ru.project.IStudyEnglish.learning_module.entity.TypeSource;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuilderSource {


    BuilderWord builderWord;

    List<Source> listSource = new ArrayList<>();

    @Autowired
    public BuilderSource(BuilderWord builderWord) {
        this.builderWord = builderWord;
    }

    public Source get(String sourceType, int sourceId) {
        Source source = new Source();
        //TODO добавить обработку других видов источников
        source = builderWord.get(sourceId);

        return source;
    }

    public List<Source> get(){
        get(TypeSource.word);
        //TODO добавить другие типы источников, когда они появятся
        return this.listSource;
    }


    public List<Source> get(TypeSource typeSource){

        if(typeSource==TypeSource.word){

            this.listSource.addAll(builderWord.get());
        }
        return this.listSource;
    }

}
