package com.devground.reservationScheduler.domains.UserInfo.repository;

import com.devground.reservationScheduler.domains.UserInfo.entity.UserInfo;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByLoginId(String loginId);
    UserInfo findByUserId(Integer userId);

}
