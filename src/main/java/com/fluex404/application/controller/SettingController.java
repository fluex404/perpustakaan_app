package com.fluex404.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/setting")
public class SettingController {

    @GetMapping
    public String getSetting() {
        return "setting";
    }
}
