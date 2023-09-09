package com.devground.reservationScheduler.domains.MeetingRoomMst.repository;

import com.devground.reservationScheduler.domains.MeetingRoomMst.key.MeetingRoomId;
import com.devground.reservationScheduler.domains.MeetingRoomMst.entity.MeetingRoomMst;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRoomMstRepository extends JpaRepository<MeetingRoomMst, MeetingRoomId> {
        List<MeetingRoomMst> findById_CompanyCode(String companyCode);

}
