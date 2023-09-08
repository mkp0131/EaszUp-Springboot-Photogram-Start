package com.cos.photogramstart.domain.subscribe;

import lombok.*;

import javax.persistence.*;

import com.cos.photogramstart.domain.user.User;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "subscribe_uk", columnNames = {
                "fromUserId",
                "toUserId"
        })
})
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에 따라 시퀀스를 사용한다.
    private int id;

    @JoinColumn(name = "fromUserId")
    @ManyToOne
    private User fromUser;

    @JoinColumn(name = "toUserId")
    @ManyToOne
    private User toUser;

    private LocalDateTime createDate;

    @PrePersist // DB에 Insert 되기 직전에 실행
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }

}
