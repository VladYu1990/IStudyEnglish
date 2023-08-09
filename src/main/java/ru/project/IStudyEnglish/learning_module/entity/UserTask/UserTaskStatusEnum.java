package ru.project.IStudyEnglish.learning_module.entity.UserTask;

public enum UserTaskStatusEnum {
    notAvailable(1),
    notReadyToLearn(2),
    readyToExplore(3),
    studied(4),
    memorized(5);

    UserTaskStatusEnum(int id) {}

    public static UserTaskStatusEnum cast(int id){
        switch (id) {
            case (1):
                return notAvailable;
            case (2):
                return notReadyToLearn;
            case (3):
                return readyToExplore;
            case (4):
                return studied;
            case (5):
                return memorized;
            default:new Exception("status doesn't");
        }
        return null;
    }

}
