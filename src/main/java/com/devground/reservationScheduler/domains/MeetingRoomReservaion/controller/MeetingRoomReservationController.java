package com.devground.reservationScheduler.domains.MeetingRoomReservaion.controller;

import com.devground.reservationScheduler.domains.MeetingRoomMst.dto.MeetingRoomMstDto;
import com.devground.reservationScheduler.domains.MeetingRoomReservaion.dto.*;
import com.devground.reservationScheduler.domains.base.ResultResponse;
import com.devground.reservationScheduler.domains.MeetingRoomReservaion.service.MeetingRoomReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reservation")
public class MeetingRoomReservationController {

    @Autowired
    private MeetingRoomReservationServiceImpl meetingRoomReservationService;


    @PostMapping("/create")
    public ResultResponse<?> createReservation(@RequestBody ReservationCreationDto dto) {

        return meetingRoomReservationService.createReservation(dto);
    }

    @PostMapping("/update")
    public ResultResponse<?> updateReservation(@RequestBody ReservationUpdateDto dto) {
        return meetingRoomReservationService.updateReservation(dto);
    }

    @PostMapping("/delete")
    public ResultResponse<?> updateReservation(@RequestBody ReservationDeleteDto dto) {
        return meetingRoomReservationService.deleteReservation(dto);
    }


    // 추가적으로 형식에 맞게 변환하기 + service
    @PostMapping("/dailyReservation")
    public ResponseEntity<ResultResponse<List<ReservationResult>>> getDailyReservations(@RequestBody Map<String, String> request) {
        try {
            List<ReservationResult> rooms = meetingRoomReservationService.dailyReservaionInfo(request.get("companyCode"),request.get("useDate"),"L");
            return ResponseEntity.ok(new ResultResponse<>(true, null, null, rooms));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResultResponse<>(false, "ERROR_CODE", e.getMessage()));
        }
    }

    /*
    @PostMapping("/dailyReservation")
    public ResultResponse<?> getDailyReservations(@RequestBody ReservationDailyInfoDto dto) {

        return meetingRoomReservationService.dailyReservaionInfo(dto);
    }
     */

}
