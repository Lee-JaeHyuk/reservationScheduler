package com.devground.reservationScheduler.domains.UserInfo.service;

import com.devground.reservationScheduler.domains.UserInfo.dto.LoginDto;
import com.devground.reservationScheduler.domains.UserInfo.dto.LoginResult;
import com.devground.reservationScheduler.domains.UserInfo.entity.UserInfo;
import com.devground.reservationScheduler.domains.base.ResultResponse;

public interface UserInfoService {

    ResultResponse<LoginResult> authenticateUser(LoginDto loginDto);
}
