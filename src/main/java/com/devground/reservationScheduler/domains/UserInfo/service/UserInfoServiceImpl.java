package com.devground.reservationScheduler.domains.UserInfo.service;


import com.devground.reservationScheduler.domains.CompanyInfo.repository.CompanyInfoRepository;
import com.devground.reservationScheduler.domains.UserInfo.dto.LoginDto;
import com.devground.reservationScheduler.domains.UserInfo.dto.LoginResult;
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

    @Autowired
    private CompanyInfoRepository companyInfoRepository;


    @Autowired
    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public ResultResponse<LoginResult> authenticateUser(LoginDto loginDto) {
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
        LoginResult loginResult = new LoginResult();
        loginResult.setUserId(user.getUserId());
        loginResult.setCompanyCode(user.getCompanyCode());
        loginResult.setCompanyName(companyInfoRepository.findByCompanyCode(user.getCompanyCode()).getCompanyName());

        return new ResultResponse<>(true, "success","로그인 성공" , loginResult);
    }


}
