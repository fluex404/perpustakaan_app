package com.fluex404.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerpustakaanController {
    @GetMapping
    public String createIndex() {
        return "index";
    }
}
