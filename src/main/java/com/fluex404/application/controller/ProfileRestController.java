package com.fluex404.application.controller;

import com.fluex404.application.dao.ProfileDao;
import com.fluex404.application.entity.Profile;
import com.fluex404.application.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin
public class ProfileRestController {
    @Autowired
    private ProfileService dao;

    @GetMapping
    public ResponseEntity<Profile> getProfile() {
        return new ResponseEntity<>(dao.getProfile(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> postProfile(@RequestBody @Valid Profile profile, BindingResult result) {
        Profile pr = new Profile();

        if(result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            errorMap.put("status", "error");

            result.getFieldErrors()
                    .forEach(err -> {
                        errorMap.put(err.getField(), err.getDefaultMessage());
                    });
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.OK);
        }

        if(profile.getId().equals("") || profile.getId() == null) {
            //
        } else {
            pr = dao.postProfile(profile);
        }

        return new ResponseEntity<>(pr, HttpStatus.CREATED);
    }
}
