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
    @NotBlank
    private String name;
    @Email(message = "email invalid")
    private String email;
    private String username;
    private String password;
    private Date date;

    public Profile() {
        this.id = UUID.randomUUID();
        this.date = new Date();
    }
    public Profile(String name, String email, String username, String password) {
        this();
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
