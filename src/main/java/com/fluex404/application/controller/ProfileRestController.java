package com.fluex404.application.controller;

import com.fluex404.application.dao.ProfileDao;
import com.fluex404.application.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin
public class ProfileRestController {
    @Autowired
    private ProfileDao dao;

    @GetMapping
    public ResponseEntity<List<Profile>> getProfile() {
        return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Profile> postProfile(@RequestBody @Valid Profile profile) {
        Profile pr = new Profile();
        if(profile.getId().equals("") || profile.getId() == null) {
            //
        } else {
            pr = dao.save(profile);
        }

        return new ResponseEntity<>(pr, HttpStatus.CREATED);
    }
}
