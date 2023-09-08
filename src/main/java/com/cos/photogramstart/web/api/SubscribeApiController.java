package com.cos.photogramstart.web.api;

import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.service.SubscribeService;
import com.cos.photogramstart.web.dto.CMResDto;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
public class SubscribeApiController {

    private final SubscribeService subscribeService;

    @PostMapping(value = "/api/subscribe/{toUserId}")
    public ResponseEntity<?> postSubscribe(@AuthenticationPrincipal PrincipalDetails principalDetails,
            @PathVariable int toUserId) {

        int fromUserId = principalDetails.getUser().getId();
        int result = subscribeService.subscribe(fromUserId, toUserId);
        return new ResponseEntity<>(new CMResDto<>(result, "ok", null), HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/subscribe/{toUserId}")
    public ResponseEntity<?> deleteSubscribe(@AuthenticationPrincipal PrincipalDetails principalDetails,
            @PathVariable int toUserId) {
        int fromUserId = principalDetails.getUser().getId();
        int result = subscribeService.unSubscribe(fromUserId, toUserId);
        return new ResponseEntity<>(new CMResDto<>(result, "ok", null), HttpStatus.OK);
    }

}
