package com.cos.photogramstart.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에 따라 시퀀스를 사용한다.
    private int id;

    private String username;
    private String password;
    private String name;
    private String website;
    private String email;
    private String bio;
    private String phone;
    private String gender;
    private String avatar;
    private String role;

    private LocalDateTime createdAt;

    @PrePersist
    public void createdAt() {
        this.createdAt = LocalDateTime.now();
    }
}

