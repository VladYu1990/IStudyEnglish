package ru.project.IStudyEnglish.port.in.student;

import ru.project.IStudyEnglish.domain.Autorisation.User;
import ru.project.IStudyEnglish.domain.Dictionary.Languages;
import ru.project.IStudyEnglish.domain.Education.Student;

import java.time.Instant;
import java.util.UUID;

public interface StudentUseCase {
    void create(User user, String fullName, Languages nativeLanguages, Languages languagesForStudy, Instant instant);
    Student get(UUID studentUUID);
    Student get(User user);
    void update(Student student);
}
