package com.devground.reservationScheduler.domains.MeetingRoomReservaion.dto;


import lombok.Data;

import javax.persistence.Column;

@Data
public class ReservationResult {

    private Long reservationId;
    private String companyCode;
    private String meetingRoomCode;
    private Integer userId;
    private String useDate;
    private String useStartTime;
    private String useEndTime;
    private String reason;
    private String status;
    private String userName;


}
