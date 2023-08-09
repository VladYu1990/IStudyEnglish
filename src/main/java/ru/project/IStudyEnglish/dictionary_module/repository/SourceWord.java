package ru.project.IStudyEnglish.dictionary_module.repository;

import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.dictionary_module.entity.Word;

@Component
public interface SourceWord {


    Word getOnId(int id);
}
