package ru.project.IStudyEnglish.infrastructure.DAO;

import java.util.Date;

public class StudyTaskDAO {
    public int id;
    public int idUser;
    public int idTypeOfExerciseForRepetition;
    public int idExercise;
    public Date dateCreate;
    public Date dateUpdate;
    public Boolean deleted;
    public Date dateNextRepetition;
    public int countTrueRepetitionInRow;
    public int codeStageOfStudy;
    // 0 - куплена/добавлена,
    // 1 - первая ступень, перевод англ-рус,
    // 2 - вторая ступень, рус-англ,
    // 3 - ступень, используем в предложениях,
    // 4 - выучено, редкие повторения,
    // -1 - не повторять, но учитывать
    public Date dateLearned;

}
