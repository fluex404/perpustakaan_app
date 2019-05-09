package com.fluex404.application.service;

import com.fluex404.application.entity.Setting;

public interface SettingService {
    Setting getSetting();
    Setting postSetting(Setting setting);
}
