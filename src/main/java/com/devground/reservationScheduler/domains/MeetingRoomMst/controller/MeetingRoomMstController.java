package com.devground.reservationScheduler.domains.MeetingRoomMst.controller;


import com.devground.reservationScheduler.domains.MeetingRoomMst.dto.MeetingRoomMstDto;
import com.devground.reservationScheduler.domains.MeetingRoomMst.service.MeetingRoomMstService;
import com.devground.reservationScheduler.domains.base.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/meetingRoom")
public class MeetingRoomMstController {

    @Autowired
    private MeetingRoomMstService meetingRoomMstService;


    // 추가적으로 형식에 맞게 변환하기 + service
    @PostMapping("/meetingRoomInfo")
    public ResponseEntity<ResultResponse<List<MeetingRoomMstDto>>> getMeetingRoomInfo(@RequestBody Map<String, String> request) {
        try {
            List<MeetingRoomMstDto> rooms = meetingRoomMstService.getMeetingRoomsByCompany(request.get("companyCode"));
            return ResponseEntity.ok(new ResultResponse<>(true, null, null, rooms));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResultResponse<>(false, "ERROR_CODE", e.getMessage()));
        }
    }

    /*

   /meetingRoomInfo")
    public ResponseEntity<?> getMeetingRoomInfo(@RequestBody Map<String, String> request) {
        try {
            List<MeetingRoomMstDto> rooms = meetingRoomMstService.getMeetingRoomsByCompany(request.get("CompanyCode"));
            Map<String, Object> response = new HashMap<>();
            response.put("resultFlag", true);
            response.put("errCode", null);
            response.put("errMessage", null);
            response.put("resultData", rooms);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("resultFlag", false);
            response.put("errCode", "ERROR_CODE");
            response.put("errMessage", e.getMessage());

            return ResponseEntity.badRequest().body(response);
        }

    }*/


}
