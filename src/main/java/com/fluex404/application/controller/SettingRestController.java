package com.fluex404.application.controller;

import com.fluex404.application.dao.SettingDao;
import com.fluex404.application.entity.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/setting")
public class SettingRestController {
    @Autowired
    private SettingDao dao;
    @GetMapping
    public ResponseEntity<Setting> getSettings() {
        return new ResponseEntity<>(dao.findAll().get(0), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Setting> postSetting(@Valid @RequestBody Setting setting) {
        Setting st = new Setting();

        if(setting.getId().equals("") || setting.getId() == null) {
            //
        } else {
            st = dao.save(setting);
        }
        
        return new ResponseEntity<>(st, HttpStatus.OK);
    }
}
