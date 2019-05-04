package com.fluex404.application.service.impl;

import com.fluex404.application.dao.ProfileDao;
import com.fluex404.application.entity.Profile;
import com.fluex404.application.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileImpl implements ProfileService {
    @Autowired
    private ProfileDao dao;

    @Override
    public Profile getProfile() {
        return dao.findAll().get(0);
    }

    @Override
    public Profile postProfile(Profile profile) {
        Profile pr = new Profile();
        if (profile.getId().equals("") || profile.getId() == null) {
            //
        } else {
            pr = dao.save(profile);
        }

        return pr;
    }
}
