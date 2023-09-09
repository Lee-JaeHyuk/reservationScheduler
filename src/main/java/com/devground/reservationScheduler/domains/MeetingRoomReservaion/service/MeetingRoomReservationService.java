package com.devground.reservationScheduler.domains.MeetingRoomReservaion.service;

import com.devground.reservationScheduler.domains.MeetingRoomReservaion.dto.*;
import com.devground.reservationScheduler.domains.MeetingRoomReservaion.entity.MeetingRoomReservation;
import com.devground.reservationScheduler.domains.base.ResultResponse;

import java.util.List;

public interface MeetingRoomReservationService {

    ResultResponse<?> createReservation(ReservationCreationDto dto);
    ResultResponse<?> updateReservation(ReservationUpdateDto dto);

    ResultResponse<?> deleteReservation(ReservationDeleteDto dto);


    List<ReservationResult> dailyReservaionInfo(String companyCode, String useDate, String status);

    //ResultResponse<?> dailyReservaionInfo(ReservationDailyInfoDto dto);

}
