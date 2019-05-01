package com.fluex404.application.dao;

import com.fluex404.application.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SettingDao extends JpaRepository<Setting, UUID> {
}
