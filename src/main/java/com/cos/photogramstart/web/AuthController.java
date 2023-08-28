package com.cos.photogramstart.web;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@RequiredArgsConstructor // DI 할때 사용 / 생성자를 따로 만들 필요 X
@Controller
public class AuthController {


    private final AuthService authService;

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    @PostMapping("/auth/signup")
    public String signup(SignupDto signupDto) {
        System.out.println(signupDto);
        System.out.println("🐝 사인업 실행 :" + signupDto.getUsername());

        User user = signupDto.toEntity();
        System.out.println("엔티티: " + user);
        User userEntity = authService.singUp(user);
        System.out.println(userEntity);
        return "auth/signup";
    }

}
