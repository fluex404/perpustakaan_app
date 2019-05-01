package com.fluex404.application.controller;

import com.fluex404.application.dao.ProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
