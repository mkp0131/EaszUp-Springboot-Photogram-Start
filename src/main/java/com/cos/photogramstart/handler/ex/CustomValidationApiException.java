package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomValidationApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final Map<String, String> errMap;

    public CustomValidationApiException(String message) {
        super(message);
        this.errMap = null;
    }

    public CustomValidationApiException(String message, Map<String, String> errMap) {
        super(message);
        this.errMap = errMap;
    }

    public Map<String, String> getErrMap() {
        return errMap;
    }
}
