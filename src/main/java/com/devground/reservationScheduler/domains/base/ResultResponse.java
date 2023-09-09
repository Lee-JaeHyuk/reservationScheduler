package com.devground.reservationScheduler.domains.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponse<T> {
    private boolean resultFlag;
    private String errCode;
    private String errMessage;
    private T resultData; // 없을 경우 null 처리


    public ResultResponse(boolean resultFlag) {
        this.resultFlag = resultFlag;
    }

    public ResultResponse(boolean resultFlag, String errCode, String errMessage) {
        this.resultFlag = resultFlag;
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

}
