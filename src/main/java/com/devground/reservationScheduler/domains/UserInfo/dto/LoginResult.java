package com.devground.reservationScheduler.domains.UserInfo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResult {

    Integer userId;
    String companyCode;
    String companyName;

}
