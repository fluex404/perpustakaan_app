package com.fluex404.application.controller;

import com.fluex404.application.dao.ProfileDao;
import com.fluex404.application.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class PerpustakaanController {
    @Autowired
    private ProfileDao dao;

    @GetMapping
    public String createIndex() {
        return "index";
    }



}
