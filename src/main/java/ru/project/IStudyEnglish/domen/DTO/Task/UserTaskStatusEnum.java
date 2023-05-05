package ru.project.IStudyEnglish.domen.DTO.Task;

public enum UserTaskStatusEnum {
    notAvailable,
    notReadyToLearn,
    readyToExplore,
    studied,
    memorized


    // 0 - куплена/добавлена,
    // 1 - первая ступень, перевод англ-рус,
    // 2 - вторая ступень, рус-англ,
    // 3 - ступень, используем в предложениях,
    // 4 - выучено, редкие повторения,
    // -1 - не повторять, но учитывать

}
