package com.devground.reservationScheduler.domains.UserInfo.controller;

import com.devground.reservationScheduler.domains.UserInfo.dto.LoginDto;
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
    public ResultResponse<?> login(@RequestBody LoginDto loginDto) {
        return userInfoService.authenticateUser(loginDto);
    }

}
