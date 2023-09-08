package com.cos.photogramstart.web;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.CMResDto;
import com.cos.photogramstart.web.dto.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public String profile(@PathVariable int id) {
        return "user/profile";
    }

    @GetMapping("/user/{id}/update")
    public String getUpdate(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        // 간단하게 꺼내오는법 / 스프링시큐리티가 주는 principalDetails 로 접근
        // System.out.println("세션정보: " + principalDetails.getUsername());
        return "user/update";
    }

}
