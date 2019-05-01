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
@RequestMapping("/api")
@CrossOrigin
public class APIController {
    @Autowired
    private ProfileDao dao;

    @GetMapping("/profile")
    public ResponseEntity<List<Profile>> getProfile() {
        return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
    }
    @PostMapping("/profile")
    public ResponseEntity<Profile> postProfile(@RequestBody @Valid Profile profile) {
        return new ResponseEntity<>(dao.save(profile), HttpStatus.CREATED);
    }
}
