package ru.project.IStudyEnglish.Application.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.Application.Student.StudentUseCaseImpl;
import ru.project.IStudyEnglish.Application.User.UserUseCaseImpl;
import ru.project.IStudyEnglish.domain.Autorisation.User;
import ru.project.IStudyEnglish.domain.Education.Student;
import ru.project.IStudyEnglish.domain.Education.Task;

import java.util.Collection;

@RestController
@RequestMapping("/v1/{token}/tasks/")
public class taskController {
    TaskUseCaseImpl taskUseCaseImpl;

    UserUseCaseImpl userUseCase;

    StudentUseCaseImpl studentUseCase;

    @Autowired
    public taskController(TaskUseCaseImpl taskUseCaseImpl, UserUseCaseImpl userUseCase, StudentUseCaseImpl studentUseCase) {
        this.taskUseCaseImpl = taskUseCaseImpl;
        this.userUseCase = userUseCase;
        this.studentUseCase = studentUseCase;
    }



    @PostMapping("/create/{exercise_uuid}")
    public String create(@PathVariable String token,@PathVariable String exercise_uuid){
        //todo
        User user = userUseCase.get(token);
        Student student = studentUseCase.get(user);
        return "ok";

    }

    @PostMapping("/getNext/{amount}")
    public Collection<Task> getNext(@PathVariable String token, @PathVariable int amount){
        //todo
        try {
            User user = userUseCase.get(token);
            Student student = studentUseCase.get(user);
            Integer.valueOf(amount);
            return taskUseCaseImpl.getNextTasks(student,amount);
        }
        catch (Exception e){
            return null;
        }
    }

}
