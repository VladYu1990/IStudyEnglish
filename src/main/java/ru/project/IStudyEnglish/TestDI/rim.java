package ru.project.IStudyEnglish.TestDI;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Log4j2
@Component
@Scope("prototype")
public class rim {
    private String diameter = "17";

    public rim(){
        log.error("rim created");
    }

    public String getDiameter() {
        return diameter;
    }
}
