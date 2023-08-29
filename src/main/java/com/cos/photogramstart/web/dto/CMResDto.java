package com.cos.photogramstart.web.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CMResDto<T> {
    private int code; // http 리퀘스트 코드
    private String message;
    private T data;
}