package com.fluex404.application.controller;

import com.fluex404.application.dao.SettingDao;
import com.fluex404.application.entity.Setting;
import com.fluex404.application.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/setting")
public class SettingRestController {
    @Autowired
    private SettingService service;

    @GetMapping
    public ResponseEntity<Setting> getSettings() {
        return new ResponseEntity<>(service.getSetting(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Setting> postSetting(@Valid @RequestBody Setting setting) {
        return new ResponseEntity<>(service.postSetting(setting), HttpStatus.OK);
    }
}
