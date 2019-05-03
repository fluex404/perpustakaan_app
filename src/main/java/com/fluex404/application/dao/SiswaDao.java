package com.fluex404.application.dao;

import com.fluex404.application.entity.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SiswaDao extends JpaRepository<Siswa, UUID> {
}
