package ru.project.IStudyEnglish.controllers.rest.v1;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//класс для работы с фронтом
@RestController
@RequestMapping("/v1/answer_from_user/{token}/{id_topik_user}")
@Log4j2
public class AnswerController {

    @RequestMapping("/")
    public Object greetingNextTopic(@PathVariable String token, @PathVariable String id_topik_user) {
        String string = "";
        //валидация юзера
        //поиск изера по токену
        //поиск топика и его апдейт
        if (string.equals("")){
            return "ок";
        }
        else {
            return string;
        }
    }
}
