package com.fluex404.application.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Setting {
    @Id
    private UUID id;
    private String nama_sekolah;
    @Column(length = 10000000)
    private String logo;

    public Setting() {
        this.id = UUID.randomUUID();
    }
    public Setting(String nama_sekolah, String logo){
        this();
        this.nama_sekolah = nama_sekolah;
        this.logo = logo;
    }
}
