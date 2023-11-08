package ru.project.IStudyEnglish.NewModule.Domein;

/*
 * класс нужен для информирования системы какой тип изучения у конкретной таски
 */
public enum TypeTask {
    /*
     * задание на изучение написания таски
     */
    WRITING,
    /*
     * задание на изучение чтения/понимания таски
     */
    READING,
    /*
     * задание на правильное произношение таски
     */
    SPEAKING,
    /*
     * задание на умение понять таску на слух
     */
    HEARING
}
