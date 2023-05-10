package ru.project.IStudyEnglish.TestDI;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Log4j2
@Component
@Scope("prototype")
public class wheel {
    private rim rim;
    private String brand = "Pirelly";

    @Autowired
    public void wheel(rim rim){
        log.error("wheel created");
        this.rim = rim;
    }

    public ru.project.IStudyEnglish.TestDI.rim getRim() {
        return rim;
    }

    public String getBrand() {
        return brand;
    }
}
