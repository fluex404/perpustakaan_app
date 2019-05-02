package com.fluex404.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/profile")
public class ProfileController {

    @GetMapping
    public String getProfile() {
        return "profile";
    }


}
