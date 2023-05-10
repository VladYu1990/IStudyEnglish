package ru.project.IStudyEnglish.TestDI;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test/")
@Log4j2
public class ControllerTest1 {


    @Autowired
    private Car carForReturn;

    @Value("${test.test}")
    private String str;

    @RequestMapping("/{color}")

    public Car test(
                    @PathVariable String color){
        carForReturn.setColor(new Color(color));
        return this.carForReturn;
    }
    @Autowired
    public Car carReturn(Car car){
        return car;
    }

}
