package com.fluex404.application.service;

import com.fluex404.application.entity.Profile;

public interface ProfileService {
    Profile getProfile();
    Profile postProfile(Profile profile);
}
