package ru.project.IStudyEnglish.learning_module.entity;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.dictionary_module.entity.Word;

@Log4j2
public enum SourcesEnum {
    word,
    sentence,
    phrase,
    unknownType;

    public String getString(Object o){
        if (o.getClass() == Word.class){
            return "word";
        } else {
            log.error("SourcesEnum for " + o.getClass() + " class didn't find type");
            return "didn't find type";
        }
    }

    public SourcesEnum get(Object o){
        if (o.getClass() == Word.class){
            return SourcesEnum.word ;
        } else {
            log.error("SourcesEnum for " + o.getClass() + " class didn't find type");
            return SourcesEnum.unknownType;
        }
    }
}
