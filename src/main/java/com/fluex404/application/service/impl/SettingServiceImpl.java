package com.fluex404.application.service.impl;

import com.fluex404.application.dao.SettingDao;
import com.fluex404.application.entity.Setting;
import com.fluex404.application.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl implements SettingService {
    @Autowired
    private SettingDao dao;

    @Override
    public Setting getSetting() {
        return dao.findAll().get(0);
    }

    @Override
    public Setting postSetting(Setting setting) {
        if(setting.getId().equals("") || setting.getId() == null) {
            return setting;
        } else {
            return dao.save(setting);
        }
    }
}
