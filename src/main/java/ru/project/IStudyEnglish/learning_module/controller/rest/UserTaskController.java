package ru.project.IStudyEnglish.learning_module.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.learning_module.controller.UserTaskDTO;

@RestController
@RequestMapping("/v1/{token}/user_tasks/")
@Log4j2
@Scope("prototype")
public class UserTaskController {

    @Autowired
    UserTaskApiAdapter userTaskApiAdapter;



    @RequestMapping("/{source}/{id_source}/create/")
    public String createUserTask(@PathVariable String token, @PathVariable String source,@PathVariable int id_source) {
        //TODO
        return "ok";
    }

    @RequestMapping("/create_all/")
    public String createUserTaskAll(@PathVariable String token) {
        userTaskApiAdapter.createAll(token);
        return "ok";
    }


    @RequestMapping("/next/get/")
    public UserTaskDTO getNextUserTask(@PathVariable String token)  {
        return userTaskApiAdapter.getNextUserTask(token);
    }

    @RequestMapping("/get/{id}")
    public UserTaskDTO getNextUserTask(@PathVariable String token,@PathVariable int id) {
        return userTaskApiAdapter.getUserTask(token,id);
    }

    @RequestMapping("/{id_user_task}/response/{id_response}")
    public String response(@PathVariable String token,@PathVariable int id_user_task,@PathVariable int id_response) {
        userTaskApiAdapter.response(token,id_user_task,id_response);
        return "ok";
    }

}
