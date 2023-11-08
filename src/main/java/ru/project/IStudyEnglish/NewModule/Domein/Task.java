package ru.project.IStudyEnglish.NewModule.Domein;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private int id;
    private String question;
    private String answer;
    private String example;
    private Time create;
    private Time update;


}
