package com.fluex404.application.controller;

import com.fluex404.application.dao.ProfileDao;
import com.fluex404.application.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class IndexController {
    @Autowired
    private ProfileDao dao;

    @GetMapping
    public String createIndex(Model model) {
        Profile profile = dao.findAll().get(0);

        model.addAttribute("profile", profile);

        return "index";
    }
}
