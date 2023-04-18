package ru.project.IStudyEnglish.domen.DTO.Task;

import ru.project.IStudyEnglish.domen.DTO.Task.ForRepetition.TaskForRepetition;
import ru.project.IStudyEnglish.domen.DTO.Task.ForStudying.TaskForStudying;

public class TaskFactory {
    Task task = null;
    public TaskFactory(){

    }

    public Task createTask(){

        //Дергаем чейзер, он идем в бд, выгружаем самый старый для повторения/изучения у этого юзера из доступных
        //определяем в бд типтаски и исходя из него, содаем нужный тип таски и передаем в нее код таски

        TaskType taskType = TaskType.repetition;//допустим этот тип
        String id = "8";//допустим с этим кодом

        switch (taskType){
            case repetition:
                this.task = new TaskForRepetition(id);
                break;
            case studying:
                this.task = new TaskForStudying(id);
                break;
        }
        return task;
    }
}
