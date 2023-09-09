package com.devground.reservationScheduler.domains.UserInfo.service;


import com.devground.reservationScheduler.domains.UserInfo.entity.UserInfo;
import com.devground.reservationScheduler.domains.UserInfo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private UserInfoRepository userInfoRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserInfo findByLoginId(String loginId) {
        return userInfoRepository.findByLoginId(loginId);
    }
}
