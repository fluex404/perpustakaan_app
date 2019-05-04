package com.fluex404.application.service;

import com.fluex404.application.entity.Profile;
import org.springframework.http.ResponseEntity;

public interface ProfileService {
    Profile getProfile();
    Profile postProfile(Profile profile);
}
