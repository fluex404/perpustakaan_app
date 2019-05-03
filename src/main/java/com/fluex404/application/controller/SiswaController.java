package com.fluex404.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/siswa")
public class SiswaController {
    @GetMapping
    public String getSiswa() {
        return "siswa";
    }
}
