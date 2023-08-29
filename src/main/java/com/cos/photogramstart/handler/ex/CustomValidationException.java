package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomValidationException extends RuntimeException {

    private static final long serialVersionUID = 9040654718873050613L;

    private final String message;

    private final Map<String, String> errMap;

    public CustomValidationException(String message, Map<String, String> errMap) {
        super(message);
        this.message = message;
        this.errMap = errMap;
    }

    public Map<String, String> getErrMap() {
        return errMap;
    }
}
