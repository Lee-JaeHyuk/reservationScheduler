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
    public ResponseEntity<ResultResponse> login(@RequestBody LoginDto loginRequest) {
        ResultResponse response = new ResultResponse();
        UserInfo user = userInfoService.authenticate(loginRequest.getLoginId(), loginRequest.getPassword());
        if (user != null) {
            response.setResultFlag(true);
            return ResponseEntity.ok().body(response);
        } else {
            response.setResultFlag(false);
            response.setErrCode("LOGIN_ERR");
            response.setErrMessage("Login Failed");
            return ResponseEntity.badRequest().body(response);
        }

    }


}
