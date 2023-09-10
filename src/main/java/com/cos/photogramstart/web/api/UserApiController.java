package com.cos.photogramstart.web.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationApiException;
import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.CMResDto;
import com.cos.photogramstart.web.dto.user.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMResDto<?> postUpdate(@Valid UserUpdateDto userUpdateDto, BindingResult bindingResult, @PathVariable int id,
            @AuthenticationPrincipal PrincipalDetails principalDetails) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errMap = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errMap.put(error.getField(), error.getDefaultMessage());
                System.out.println(error.getDefaultMessage());
            }

            throw new CustomValidationApiException("유효성 검사 실패", errMap);
        } else {
            User userEntity = userService.updateUser(id, userUpdateDto.toEntity());
            System.out.println("🍟 UserEntity: " + userEntity);

            // 스프링 시큐리티에 저장되어 있는 session 을 변경한다.
            principalDetails.setUser(userEntity);

            return new CMResDto<>(1, "회원정보 수정완료", userEntity);

        }
    }
}
