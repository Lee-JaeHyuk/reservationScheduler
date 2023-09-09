package com.devground.reservationScheduler.domains.UserInfo.service;

import com.devground.reservationScheduler.domains.UserInfo.entity.UserInfo;

public interface UserInfoService {

    UserInfo authenticate(String id, String pw);
}
