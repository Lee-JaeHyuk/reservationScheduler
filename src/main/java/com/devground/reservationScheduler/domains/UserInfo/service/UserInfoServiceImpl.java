package com.devground.reservationScheduler.domains.UserInfo.service;


import com.devground.reservationScheduler.domains.UserInfo.dto.LoginDto;
import com.devground.reservationScheduler.domains.UserInfo.entity.UserInfo;
import com.devground.reservationScheduler.domains.UserInfo.repository.UserInfoRepository;
import com.devground.reservationScheduler.domains.base.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public ResultResponse<?> authenticateUser(LoginDto loginDto) {
        String loginId = loginDto.getLoginId();
        String password = loginDto.getPassword();

        // 로그인 ID로 사용자 정보 조회
        UserInfo user = userInfoRepository.findByLoginId(loginId);

        if (user == null) {
            return new ResultResponse<>(false, "ERR001", "사용자를 찾을 수 없습니다.");
        }

        // 패스워드 검증
        if (!"1".equals(password)) {
            return new ResultResponse<>(false, "ERR002", "패스워드가 올바르지 않습니다.");
        }

        // 로그인 성공
        return new ResultResponse<>(true, "로그인 성공", "예약에 성공했습니다");
    }


}
