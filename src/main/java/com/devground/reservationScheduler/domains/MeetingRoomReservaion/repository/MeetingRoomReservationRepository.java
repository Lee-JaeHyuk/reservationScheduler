package com.devground.reservationScheduler.domains.MeetingRoomReservaion.repository;

import com.devground.reservationScheduler.domains.MeetingRoomReservaion.entity.MeetingRoomReservation;
import com.devground.reservationScheduler.domains.MeetingRoomReservaion.key.MeetingRoomReservationId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRoomReservationRepository extends JpaRepository<MeetingRoomReservation,Long> {

    List<MeetingRoomReservation> findById_CompanyCodeAndId_UseDateAndStatus(String companyCode, String useDate, String status);

    List<MeetingRoomReservation> findById_CompanyCodeAndId_MeetingRoomCodeAndId_UseDate(String companyCode, String meetingRoomCode, String useDate);

    List<MeetingRoomReservation> findById_CompanyCodeAndId_MeetingRoomCodeAndId_UseDateAndStatus(String companyCode, String meetingRoomCode, String useDate, String status);
    MeetingRoomReservation findById(MeetingRoomReservationId id);

    MeetingRoomReservation findByIdAndStatus(MeetingRoomReservationId id, String status);

    List<MeetingRoomReservation> findAllById_CompanyCodeAndId_MeetingRoomCodeAndId_UseDate(
            String companyCode,
            String meetingRoomCode,
            String useDate
    );

    List<MeetingRoomReservation> findAllById_CompanyCodeAndId_UserIdAndStatus(
            String companyCode,
            Integer userId,
            String status
    );

}
