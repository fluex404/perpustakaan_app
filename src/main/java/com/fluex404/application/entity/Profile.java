package com.fluex404.application.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Profile {
    @Id
    private UUID id;
    @NotBlank(message = "nama tidak boleh kosong!")
    private String nama;
    @Email(message = "email tidak sah!")
    @NotBlank(message = "email tidak boleh kosong!")
    private String email;
    @NotBlank(message = "username tidak boleh kosong!")
    private String username;
    @NotBlank(message = "username tidak boleh kosong!")
    private String password;
    @Column(length = 1000000)
    private String photo;
    private Date date;

    public Profile() {
        this.id = UUID.randomUUID();
    }
    public Profile(String nama, String email, String username, String password, String photo) {
        this();
        this.date = new Date();
        this.nama = nama;
        this.email = email;
        this.username = username;
        this.password = password;
        this.photo = photo;
    }
    public Profile(UUID id, String nama, String email, String username, String password, String photo) {
        this.id = id;
        this.date = new Date();
        this.nama = nama;
        this.email = email;
        this.username = username;
        this.password = password;
        this.photo = photo;
    }
}
