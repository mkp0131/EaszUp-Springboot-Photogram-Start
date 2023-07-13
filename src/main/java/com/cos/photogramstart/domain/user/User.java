package com.cos.photogramstart.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data // getter, setter 생성
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id // pk 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스 설정
    private int id;
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
