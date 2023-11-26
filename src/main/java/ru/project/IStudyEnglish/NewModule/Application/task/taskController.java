package ru.project.IStudyEnglish.NewModule.Application.task;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/v1/{token}/tasks/")
@Log4j2
public class taskController {


    @PostMapping("/create/{exercise_uuid}")
    public String create(@PathVariable String token,@PathVariable String exercise_uuid){
//todo

        return "ok";

    }

    @PutMapping("/{task_id}/response_answer/{answer_id}?{test}")
    public String responseAnswer(@PathVariable String token,@PathVariable String task_id,@PathParam("test") int test){
        //todo

        return "ok";

    }
}
