package ru.project.IStudyEnglish;


import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class Main {
    //private static final Logger logger = LogManager.getLogger();


    public static void main(String[] args) {

        SpringApplication.run(Main.class);
        log.info("The application started");


    }
}
