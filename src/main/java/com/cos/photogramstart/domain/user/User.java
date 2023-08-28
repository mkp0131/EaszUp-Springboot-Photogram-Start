package com.cos.photogramstart.domain.user;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에 따라 시퀀스를 사용한다.
    private int id;

    @Column(length = 20, unique = true)
    private String username;
    private String password;
    private String name;
    private String website;
    private String bio; // 자기소개
    private String email;
    private String phone;
    private String gender;
    private String profileImageUrl;
    private String role;


    private LocalDateTime createDate;

    @PrePersist // DB에 Insert 되기 직전에 실행
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
