package com.cos.photogramstart.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.subscribe.Subscribe;
import com.cos.photogramstart.domain.subscribe.SubscribeRepository;
import com.cos.photogramstart.handler.ex.CustomApiException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;

    // 구독
    @Transactional
    public int subscribe(int fromUserId, int toUserId) {
        try {
            int result = subscribeRepository.mSubscribe(fromUserId, toUserId);
            return result;
        } catch (Exception e) {
            throw new CustomApiException("이미 처리 되었습니다.");
        }
    }

    // 구독취소
    @Transactional
    public int unSubscribe(int fromUserId, int toUserId) {
        int result = subscribeRepository.mUnSubscribe(fromUserId, toUserId);
        return result;
    }

}
