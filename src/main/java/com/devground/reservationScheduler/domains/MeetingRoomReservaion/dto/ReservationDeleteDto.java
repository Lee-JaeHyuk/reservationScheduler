package com.devground.reservationScheduler.domains.MeetingRoomReservaion.dto;

import lombok.Data;

@Data
public class ReservationDeleteDto {
    private Long reservationId;      // 예약번호
    private String companyCode;     // 회사코드
    private String meetingRoomCode; // 회의실코드
    private Integer userId;          // 사용자아이디
    private String useDate;         // 사용일자
}
