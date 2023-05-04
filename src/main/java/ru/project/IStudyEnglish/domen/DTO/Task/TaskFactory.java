package ru.project.IStudyEnglish.domen.DTO.Task;

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
                break;
            case studying:
                break;
        }
        return task;
    }
}
