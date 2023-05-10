package ru.project.IStudyEnglish.infrastructure.repository.PostqresDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConConfig {
    @Value("${spring.datasource.url}")
    private String DB_url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    public ConConfig(){
    }

    public String getDB_url() {
        return DB_url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
