package com.cos.photogramstart.web;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


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
    public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            Map<String, String> errMap = new HashMap<>();
            for (FieldError error: bindingResult.getFieldErrors()) {
                errMap.put(error.getField(), error.getDefaultMessage());
                System.out.println(error.getDefaultMessage());
            }

            throw new CustomValidationException("유효성 검사 실패", errMap);
        }
        else {
            User user = signupDto.toEntity();
            User userEntity = authService.singUp(user);
            return "auth/signup";
        }

    }

}
