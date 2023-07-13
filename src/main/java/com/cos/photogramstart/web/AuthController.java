package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {
    @GetMapping("/auth/signin")
    public String signinForm(String id) {
        System.out.println("쿼리스트링: " + id);
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    @PostMapping("/auth/signup")
    public String signup(@RequestBody SignupVO data) {
        System.out.println("username: " + data.getUsername());
        System.out.println("email: " + data.getEmail());
        return "auth/signup";
    }

}
