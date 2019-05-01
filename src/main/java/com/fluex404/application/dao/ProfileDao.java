package com.fluex404.application.dao;

import com.fluex404.application.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileDao extends JpaRepository<Profile, UUID> {

}
