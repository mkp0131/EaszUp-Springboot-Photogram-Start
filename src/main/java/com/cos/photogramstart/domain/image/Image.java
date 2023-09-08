package com.cos.photogramstart.domain.image;

import lombok.*;

import javax.persistence.*;

import com.cos.photogramstart.domain.user.User;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에 따라 시퀀스를 사용한다.
    private int id;

    private String caption;

    private String postImageUrl;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;

    // TODO: 좋아요
    // TODO: 댓글

    private LocalDateTime createDate;

    @PrePersist // DB에 Insert 되기 직전에 실행
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
