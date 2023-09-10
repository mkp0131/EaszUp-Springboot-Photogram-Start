package com.cos.photogramstart.web;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.user.UserProfileDto;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{pageUserId}")
    public String profile(@PathVariable int pageUserId, Model model,
            @AuthenticationPrincipal PrincipalDetails principalDetails) {
        UserProfileDto userProfileDto = userService.profile(pageUserId, principalDetails.getUser().getId());
        model.addAttribute("dto", userProfileDto);
        return "user/profile";
    }

    @GetMapping("/user/{id}/update")
    public String getUpdate(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        // 간단하게 꺼내오는법 / 스프링시큐리티가 주는 principalDetails 로 접근
        // System.out.println("세션정보: " + principalDetails.getUsername());
        return "user/update";
    }

}
