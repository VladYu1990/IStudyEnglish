package ru.project.IStudyEnglish.repository;

public class Profile{

        int id;
        String firstName;
        String lastName;
        int age;

        public Profile(){
            this.id = 1;
            this.firstName = "test";
            this.lastName = "test";
            this.age = 1;
        };

        public int getId(){
            return id;
        };

        public int getAge(){
            return age;
        };

}