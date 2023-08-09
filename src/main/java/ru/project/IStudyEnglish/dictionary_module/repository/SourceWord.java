package ru.project.IStudyEnglish.dictionary_module.repository;

import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.entity.Word;

import java.util.List;

@Component
public interface SourceWord {


    Word get(int id);

    List<Word> get();
}
