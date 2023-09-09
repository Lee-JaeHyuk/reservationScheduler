package com.devground.reservationScheduler.domains.MeetingRoomReservaion.dto;

import lombok.Data;

@Data
public class ReservationUpdateDto {
    private Long reservationId;
    private String companyCode;
    private String meetingRoomCode;
    private Integer userId;
    private String useDate;
    private String useStartTime;
    private String useEndTime;
    private String reason;
}
