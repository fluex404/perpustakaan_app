package com.fluex404.application.controller;

import com.fluex404.application.dao.ProfileDao;
import com.fluex404.application.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/profile")
    public String getProfile(Model modal) {
        Profile profile = dao.findAll().get(0);

        modal.addAttribute("profile", profile);

        return "profile";
    }


}
