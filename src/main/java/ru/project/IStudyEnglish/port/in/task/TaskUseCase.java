package ru.project.IStudyEnglish.port.in.task;


import ru.project.IStudyEnglish.domain.Education.Answer;
import ru.project.IStudyEnglish.domain.Education.Exercise;
import ru.project.IStudyEnglish.domain.Education.Student;
import ru.project.IStudyEnglish.domain.Education.Task;

import java.time.Instant;
import java.util.Collection;
import java.util.UUID;

/**
 * список кейсов с тасками
 * создать одну таску
 * создать несколько тасок
 * найти таску по коду
 * найти следующую таску 1
 * найти следующие таски N
 * проверить ответ на правильность
 * апдейт таски при верном ответе
 * апдейт таски при не верном ответе
 * удалить таску
 * удалить таски
 */
public interface TaskUseCase {

void createTask(Student student, Exercise exercise, Instant instant);
void createTasks(Student student,Collection<Exercise> exerciseList, Instant instant);
Task getByUUID(UUID uuid);
Collection<Task> getNextTasks(Student student,int amount);
boolean checkTheAnswer(Task task, Answer answer, Instant instant);
void updateIfAnswerIsTrue(Task task, Instant instant);
void updateIfAnswerIsFalse(Task task, Instant instant);
void delete(Task task, Instant instant);
void deleteTasks(Collection<Task> taskCollection, Instant instant);
}
