package com.fluex404.application.service;

import com.fluex404.application.entity.Siswa;

import java.util.List;
import java.util.UUID;

public interface SiswaService {
    Siswa saveOrUpdate(Siswa siswa);
    List<Siswa> findAll();
    Siswa getSiswaById(UUID id);
    boolean deleteSiswaById(UUID id);
}
