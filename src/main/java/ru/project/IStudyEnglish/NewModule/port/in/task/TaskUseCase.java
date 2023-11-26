package ru.project.IStudyEnglish.NewModule.port.in.task;


import java.util.Collection;
import java.util.UUID;

public interface TaskUseCase {

void createTask(UUID studentUUID, UUID exerciseUUID);

void createTaskList(UUID studentUUID,Collection<UUID> exerciseUUIDList);
}
