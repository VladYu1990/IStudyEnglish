package ru.project.IStudyEnglish.TestDI;

import org.springframework.stereotype.Component;

@Component
public class Color {

    String color = "grey";

    public Color() {
    }

    public String getColor() {
        return color;
    }
}
