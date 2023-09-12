package com.devground.reservationScheduler.domains.UserInfo.controller;

import com.devground.reservationScheduler.domains.UserInfo.dto.LoginDto;
import com.devground.reservationScheduler.domains.UserInfo.dto.LoginResult;
import com.devground.reservationScheduler.domains.UserInfo.entity.UserInfo;
import com.devground.reservationScheduler.domains.UserInfo.service.UserInfoService;
import com.devground.reservationScheduler.domains.UserInfo.service.UserInfoServiceImpl;
import com.devground.reservationScheduler.domains.base.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public ResponseEntity<ResultResponse<LoginResult>> login(@RequestBody LoginDto loginDto) {
        try {
            // 로그인 요청 처리
            ResultResponse<LoginResult> loginResponse = userInfoService.authenticateUser(loginDto);

            // 로그인 결과를 확인
            if (loginResponse.getResultData() != null) {
                return ResponseEntity.ok(loginResponse);
            } else {
                return ResponseEntity.badRequest().body(loginResponse);
            }
        } catch (Exception e) {
            // 예외 처리
            return ResponseEntity.badRequest().body(new ResultResponse<>(false, "ERROR", e.getMessage()));
        }
    }

}
