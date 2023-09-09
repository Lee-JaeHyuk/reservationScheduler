package com.devground.reservationScheduler.domains.MeetingRoomMst.service;


import com.devground.reservationScheduler.domains.MeetingRoomMst.dto.MeetingRoomMstDto;
import com.devground.reservationScheduler.domains.MeetingRoomMst.entity.MeetingRoomMst;
import com.devground.reservationScheduler.domains.MeetingRoomMst.repository.MeetingRoomMstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeetingRoomMstServiceImpl implements MeetingRoomMstService{

    @Autowired
    private MeetingRoomMstRepository meetingRoomMstRepository;

    @Override
    public List<MeetingRoomMstDto> getMeetingRoomsByCompany(String companyCode) {
        List<MeetingRoomMst> meetingRooms = meetingRoomMstRepository.findById_CompanyCode(companyCode);
        return meetingRooms.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private MeetingRoomMstDto convertToDto(MeetingRoomMst meetingRoom) {
        MeetingRoomMstDto dto = new MeetingRoomMstDto();
        dto.setCompanyCode(meetingRoom.getId().getCompanyCode());
        dto.setMeetingRoomCode(meetingRoom.getId().getMeetingRoomCode());
        dto.setMeetingRoomName(meetingRoom.getMeetingRoomName());
        return dto;
    }

}
