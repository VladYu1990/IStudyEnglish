package ru.project.IStudyEnglish.learning_module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.IStudyEnglish.learning_module.entity.Answer.Answer;
import ru.project.IStudyEnglish.learning_module.repository.Answer.AnswersDAO;

import java.util.List;

@Component
public class BuilderAnswer {

    AnswersDAO answersDAO;

    public BuilderAnswer() {
    }

    @Autowired
    public BuilderAnswer(AnswersDAO answersDAO) {
        this.answersDAO = answersDAO;
    }

    public List<Answer> get(List<Integer> list) {
        return answersDAO.get(list);
    }

    public Answer get(int id){
        return answersDAO.get(id);
    }
    public Answer get(String str){
        return answersDAO.get(str);
    }

    public List<Answer> getAll() {
        return answersDAO.getAll();
    }
}
