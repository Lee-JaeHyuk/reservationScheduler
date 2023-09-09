package com.devground.reservationScheduler.domains.UserInfo.service;


import com.devground.reservationScheduler.domains.UserInfo.entity.UserInfo;
import com.devground.reservationScheduler.domains.UserInfo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    @Transactional
    public UserInfo authenticate(String id, String pw) {
        UserInfo user = userInfoRepository.findByLoginId(id);
        if (user != null && pw.equals(user.getLoginId())) { // 이 부분은 실제 비밀번호 해싱/검증 로직으로 변경되어야 합니다.
            return user;
        }
        return null;
    }

}
