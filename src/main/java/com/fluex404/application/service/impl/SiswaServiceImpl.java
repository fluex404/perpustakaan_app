package com.fluex404.application.service.impl;

import com.fluex404.application.dao.SiswaDao;
import com.fluex404.application.entity.Siswa;
import com.fluex404.application.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SiswaServiceImpl implements SiswaService {
    @Autowired
    private SiswaDao dao;

    @Override
    public Siswa saveOrUpdate(Siswa siswa) {
        return dao.save(siswa);
    }

    @Override
    public List<Siswa> findAll() {
        return dao.findAll();
    }

    @Override
    public boolean deleteSiswa(Siswa siswa) {
        dao.delete(siswa);
        return true;
    }
}
