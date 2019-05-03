package com.fluex404.application.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Data
public class Siswa {
    @Id
    private UUID id;
    @NotBlank(message = "nama tidak boleh kosong!")
    private String nama;
    private String kelas;
    private String nomortelp;
    @Lob
    private String alamat;

    public Siswa() {
        this.id = UUID.randomUUID();
    }
    public Siswa(String nama, String kelas, String nomortelp, String alamat) {
        this.nama = nama;
        this.kelas = kelas;
        this.nomortelp = nomortelp;
        this.alamat = alamat;
    }
}
