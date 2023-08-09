package ru.project.IStudyEnglish.user_module.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user/")
@Log4j2
@Scope("prototype")
public class UserController {

    String token = "12341dfdc13edcsddcqwefqw";



    @RequestMapping("/create/{login}/{password}")
    public String createUser(@PathVariable String login, @PathVariable String password) {
        if(login.equals("vyundt") || password.equals("52405240")){
            return this.token;
        }

        return "error";
    }
    @RequestMapping("/get_token/{login}/{password}")
    public String GetToken(@PathVariable String login, @PathVariable String password) {
        if (login.equals("vyundt") || password.equals("52405240")) {
            return this.token;
        } else {

            return "login+password not be";
        }
    }


    @RequestMapping("/relevance_token/{token}")
    public String relevanceToken(@PathVariable String token) {
        if (token.equals(this.token)){
            return "ok";
        }else {

            return "token isn't correct";
        }
    }

}
