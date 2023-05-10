package ru.project.IStudyEnglish.TestDI;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Log4j2
@Component
@Scope("prototype")
public class wheel {
    private rim rim;

    @Value("${car.brand}")
    private String brand;


    @Autowired
    public void wheel(rim rim){
        log.error("wheel created for " + brand);
        this.rim = rim;
    }

    public rim getRim() {
        return rim;
    }

    public String getBrand() {
        return brand;
    }
}
