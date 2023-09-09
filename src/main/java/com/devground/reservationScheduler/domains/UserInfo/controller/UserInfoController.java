package com.devground.reservationScheduler.domains.UserInfo.controller;

import com.devground.reservationScheduler.domains.UserInfo.dto.LoginDto;
import com.devground.reservationScheduler.domains.UserInfo.entity.UserInfo;
import com.devground.reservationScheduler.domains.UserInfo.service.UserInfoService;
import com.devground.reservationScheduler.domains.UserInfo.service.UserInfoServiceImpl;
import com.devground.reservationScheduler.domains.base.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResultResponse<?> login(@RequestBody LoginDto request) {
        UserInfo user = userInfoService.findByLoginId(request.getLoginId());

        if (user != null && passwordEncoder.matches(request.getPassword(), user.getUserName())) {
            // 로그인 성공 처리
            return new ResultResponse<>(true);
        } else {
            // 로그인 실패 처리
            return new ResultResponse<>(false, "LOGIN_FAILED", "Invalid login credentials.");
        }
    }


}
