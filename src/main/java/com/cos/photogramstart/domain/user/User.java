package com.cos.photogramstart.domain.user;

import lombok.*;

import javax.persistence.*;

import com.cos.photogramstart.domain.image.Image;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.List;

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
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    private String website;
    private String bio; // 자기소개
    @Column(nullable = false)
    private String email;
    private String phone;
    private String gender;
    private String profileImageUrl;
    private String role;

    // User 스키마 조회할때 User Id 로 등록된 모든 이미지 가져옴
    // fetch 가 LAZY 일 경우: 등록된 이미지를 가져오지마 대신 getImages 함수가 호출될때 가져옴
    // Eager: 자동으로 다가져옴

    // 따로 컬럼을 생성 X
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "user" }) // 서로 참조할때 이미지 안에 있는 user 를 무시한다.
    private List<Image> images;

    private LocalDateTime createDate;

    @PrePersist // DB에 Insert 되기 직전에 실행
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
