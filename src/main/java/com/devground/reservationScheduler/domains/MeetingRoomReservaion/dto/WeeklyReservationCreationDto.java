package com.devground.reservationScheduler.domains.MeetingRoomReservaion.dto;

import lombok.Data;

@Data
public class WeeklyReservationCreationDto {

    private String month;
    private String day;
    private String companyCode;
    private String meetingRoomCode;
    private Integer userId;
    private String useStartTime;
    private String useEndTime;
    private String reason;


}
