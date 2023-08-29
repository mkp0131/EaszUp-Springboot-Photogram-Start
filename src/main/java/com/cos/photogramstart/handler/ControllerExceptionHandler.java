package com.cos.photogramstart.handler;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.web.dto.CMResDto;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice // 모든 Exception 을 다 낚아챈다
public class ControllerExceptionHandler {
    @ExceptionHandler(CustomValidationException.class)
    public CMResDto<?> validationException(CustomValidationException e) {
        return new CMResDto<Map<String, String>>(400, e.getMessage(), e.getErrMap());
    }
}
