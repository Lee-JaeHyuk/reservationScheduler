package com.devground.reservationScheduler.domains.MeetingRoomReservaion.repository;

import com.devground.reservationScheduler.domains.MeetingRoomReservaion.entity.MeetingRoomReservation;
import com.devground.reservationScheduler.domains.MeetingRoomReservaion.key.MeetingRoomReservationId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRoomReservationRepository extends JpaRepository<MeetingRoomReservation,Long> {

    List<MeetingRoomReservation> findById_CompanyCodeAndId_UseDateAndStatus(String companyCode, String useDate, String status);

    List<MeetingRoomReservation> findById_CompanyCodeAndId_MeetingRoomCodeAndId_UseDate(String companyCode, String meetingRoomCode, String useDate);

    MeetingRoomReservation findById(MeetingRoomReservationId id);

    List<MeetingRoomReservation> findAllById_CompanyCodeAndId_MeetingRoomCodeAndId_UseDate(
            String companyCode,
            String meetingRoomCode,
            String useDate
    );

}
