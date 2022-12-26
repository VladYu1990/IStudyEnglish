package ru.project.IStudyEnglish.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.IStudyEnglish.repository.Profile;

@RestController
@RequestMapping("/prof/")
public class ProfController {


    /*@RequestMapping("/get")
    public String getProfile() {
        return "working";
    }*/

    /*private ProfileService profileService;

    public void ProfController(ProfileService profileService) {
        this.profileService = profileService;
    }*/

    @GetMapping(value = "/{personId:\\d+}")
    public Profile getProfile(@PathVariable int personId) {
        Profile profile = new Profile();

        return profile;
    }
}