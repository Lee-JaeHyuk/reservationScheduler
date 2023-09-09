package com.devground.reservationScheduler.domains.MeetingRoomMst.service;

import com.devground.reservationScheduler.domains.MeetingRoomMst.dto.MeetingRoomMstDto;

import java.util.List;

public interface MeetingRoomMstService {

    List<MeetingRoomMstDto> getMeetingRoomsByCompany(String companyCode);

}
