package ru.project.IStudyEnglish.Application.Student;

import org.springframework.stereotype.Service;
import ru.project.IStudyEnglish.domain.Autorisation.User;
import ru.project.IStudyEnglish.domain.Dictionary.Languages;
import ru.project.IStudyEnglish.domain.Education.Student;
import ru.project.IStudyEnglish.port.in.student.StudentUseCase;

import java.time.Instant;
import java.util.UUID;

@Service
public class StudentUseCaseImpl implements StudentUseCase {


    public void create(User user, String fullName, Languages nativeLanguages, Languages languagesForStudy, Instant instant) {
        Student student = Student.createStudent(user,fullName,nativeLanguages,languagesForStudy,instant);
        //todo save
    }

    public Student get(UUID studentUUID) {
        return null;
    }

    public Student get(User user) {
        return null;
    }

    public void update(Student student) {

    }
}
