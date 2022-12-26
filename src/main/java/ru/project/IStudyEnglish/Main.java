package ru.project.IStudyEnglish;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MappedTypes(Word.class)
//@MapperScan("ru.project.IStudyEnglish.infrastructure")
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
        //System.out.println(property.server.port});
       // Apkcontroller.newConnect();
    }
}
