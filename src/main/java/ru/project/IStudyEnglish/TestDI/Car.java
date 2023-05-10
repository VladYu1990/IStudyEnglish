package ru.project.IStudyEnglish.TestDI;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class Car {
    private wheel wheel1;
    private wheel wheel2;
    private wheel wheel3;
    private wheel wheel4;

    private Color color;
    private String brand = "BMW";


    @Autowired
    public Car(wheel wheel1,wheel wheel2,wheel wheel3,wheel wheel4,Color color){
        this.color = color;
        this.wheel1 = wheel1;
        this.wheel2 = wheel2;
        this.wheel3 = wheel3;
        this.wheel4 = wheel4;
        log.error("car " + this.color + " created");
    }

    public wheel getWheel1() {
        return wheel1;
    }

    public wheel getWheel2() {
        return wheel2;
    }

    public String getColor() {
        return color.getColor();
    }

    public wheel getWheel3() {
        return wheel3;
    }

    public wheel getWheel4() {
        return wheel4;
    }

    public String getBrand() {
        return brand;
    }
}
