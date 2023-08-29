package com.cos.photogramstart.web.dto.auth;


import com.cos.photogramstart.domain.user.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignupDto {
    @Size(max = 20, message = "길이가 너무 깁니다")
    private String username;

    @NotBlank(message = "패스워드 필수 입력입니다")
    private String password;
    @NotBlank(message = "Email 필수 입력입니다")
    private String email;
    @NotBlank(message = "이름 필수 입력입니다")
    private String name;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }
}
