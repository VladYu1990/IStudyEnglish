package ru.project.IStudyEnglish.domen.DTO.SourceObject;

import lombok.extern.log4j.Log4j2;
import ru.project.IStudyEnglish.infrastructure.DAO.WordDAO;

@Log4j2
public class Word extends ObjectSource {
    public int id;
    public String writing;
    public String value;
    public String likeThisWord = "1;2;3";;

    public Word() {

    }
    //private String spelling;
    //private String partOfSpeech;
    //добавить тему слова - архитектура, погода, работа и тд

    public String getTranslate() {
        return value;
    }

    public void setTranslate(String value) {
        this.value = value;
    }


    public Word(String id) {
        try {

            WordDAO date = new WordDAO(id);
            log.error(id);
            this.id = date.getId();
            this.writing = date.getWriting();
            this.value = date.getValue();
            //this.likeThisWord = date.getLikeThis();
            log.error(date.toString());
        }
        catch (Exception ex){
            log.error("все поломалось" + ex.getMessage());
        }

    }




}
