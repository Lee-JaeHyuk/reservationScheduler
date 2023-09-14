package com.devground.reservationScheduler.domains.MeetingRoomReservaion.service;


import com.devground.reservationScheduler.domains.MeetingRoomMst.dto.MeetingRoomMstDto;
import com.devground.reservationScheduler.domains.MeetingRoomMst.entity.MeetingRoomMst;
import com.devground.reservationScheduler.domains.MeetingRoomReservaion.dto.*;
import com.devground.reservationScheduler.domains.MeetingRoomReservaion.entity.MeetingRoomReservation;
import com.devground.reservationScheduler.domains.MeetingRoomReservaion.key.MeetingRoomReservationId;
import com.devground.reservationScheduler.domains.MeetingRoomReservaion.repository.MeetingRoomReservationRepository;
import com.devground.reservationScheduler.domains.UserInfo.repository.UserInfoRepository;
import com.devground.reservationScheduler.domains.base.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeetingRoomReservationServiceImpl implements MeetingRoomReservationService{

    @Autowired
    private MeetingRoomReservationRepository meetingRoomReservationRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Override
    @Transactional
    public ResultResponse<?> createReservation(ReservationCreationDto dto) {
        List<MeetingRoomReservation> existingReservations = meetingRoomReservationRepository.findById_CompanyCodeAndId_MeetingRoomCodeAndId_UseDateAndStatus(dto.getCompanyCode(), dto.getMeetingRoomCode(), dto.getUseDate(),"L");

        for (MeetingRoomReservation reservation : existingReservations) {
            if ((dto.getUseStartTime().compareTo(reservation.getUseEndTime()) < 0 && dto.getUseEndTime().compareTo(reservation.getUseStartTime()) > 0)) {
                return new ResultResponse<>(false, "ERR001", "해당 시간에 예약이 존재합니다.");
            }
        }

        MeetingRoomReservation newReservation = new MeetingRoomReservation();
        MeetingRoomReservationId id = new MeetingRoomReservationId(null, dto.getCompanyCode(), dto.getMeetingRoomCode(), dto.getUserId(), dto.getUseDate());

        newReservation.setId(id);
        newReservation.setUseStartTime(dto.getUseStartTime());
        newReservation.setUseEndTime(dto.getUseEndTime());
        newReservation.setReason(dto.getReason());
        newReservation.setStatus("L");

        meetingRoomReservationRepository.save(newReservation);

        return new ResultResponse<>(true);
    }

    @Override
    public ResultResponse<?> createWeeklyReservation(WeeklyReservationCreationDto dto) {
        try {
            String companyCode = dto.getCompanyCode();
            String meetingRoomCode = dto.getMeetingRoomCode();
            Integer userId = dto.getUserId();
            String useStartTime = dto.getUseStartTime();
            String useEndTime = dto.getUseEndTime();
            String reason = dto.getReason();

            // 입력된 월과 요일 정보
            String month = dto.getMonth().substring(2);
            String day = dto.getDay();

            // 현재 연도
            int currentYear = LocalDate.now().getYear();

            // 주어진 월과 요일 정보를 기반으로 주간 예약 생성
            LocalDate startDate = LocalDate.of(currentYear, Integer.parseInt(month), 1);
            DayOfWeek desiredDayOfWeek = DayOfWeek.valueOf(day);

            while (startDate.getMonthValue() == Integer.parseInt(month)) {
                if (startDate.getDayOfWeek() == desiredDayOfWeek) {
                    String useDate = startDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

                    // 중복 예약 체크
                    List<MeetingRoomReservation> existingReservations = meetingRoomReservationRepository
                            .findById_CompanyCodeAndId_MeetingRoomCodeAndId_UseDateAndStatus(
                                    companyCode, meetingRoomCode, useDate, "L");

                    for (MeetingRoomReservation reservation : existingReservations) {
                        if ((useStartTime.compareTo(reservation.getUseEndTime()) < 0
                                && useEndTime.compareTo(reservation.getUseStartTime()) > 0)) {
                            // 중복 예약이 있는 경우 실패
                            return new ResultResponse<>(false, "ERR001", "해당 시간에 예약이 존재합니다.");
                        }
                    }


                    // 중복 예약이 없을 때 주간 예약 생성
                    MeetingRoomReservation newReservation = new MeetingRoomReservation();
                    MeetingRoomReservationId id = new MeetingRoomReservationId(null, companyCode, meetingRoomCode, userId, useDate);

                    newReservation.setId(id);
                    newReservation.setUseStartTime(useStartTime);
                    newReservation.setUseEndTime(useEndTime);
                    newReservation.setReason(reason);
                    newReservation.setStatus("L");


                    meetingRoomReservationRepository.save(newReservation);
                }
                startDate = startDate.plusDays(1);
            }
            return new ResultResponse<>(true);
        } catch (Exception e) {
            return new ResultResponse<>(false, "ERR", "주간 예약 생성 중 오류가 발생했습니다." + e.getMessage());
        }
    }



    @Override
    @Transactional
    public ResultResponse<?> updateReservation(ReservationUpdateDto dto) {
        MeetingRoomReservationId id = new MeetingRoomReservationId(dto.getReservationId(), dto.getCompanyCode(), dto.getMeetingRoomCode(), dto.getUserId(), dto.getUseDate());

        MeetingRoomReservation existingReservation = meetingRoomReservationRepository.findByIdAndStatus(id,"L");

        if (existingReservation == null) {
            return new ResultResponse<>(false, "ERR002", "해당 예약이 존재하지 않습니다.");
        }

        List<MeetingRoomReservation> existingReservations = meetingRoomReservationRepository.findById_CompanyCodeAndId_MeetingRoomCodeAndId_UseDateAndStatus(
                dto.getCompanyCode(), dto.getMeetingRoomCode(), dto.getUseDate(),"L");



        for (MeetingRoomReservation reservation : existingReservations) {
            // 현재 예약(reservation)과 변경하려는 예약(dto)이 같은 예약이 아닐 경우에만 시간 겹침 체크 수행
            if (!reservation.getId().getReservationId().equals(id.getReservationId())) {
                if ((dto.getUseStartTime().compareTo(reservation.getUseEndTime()) < 0 && dto.getUseEndTime().compareTo(reservation.getUseStartTime()) > 0)) {
                    return new ResultResponse<>(false, "ERR001", "해당 시간에 예약이 존재합니다.");
                }
            }
        }

        existingReservation.setUseStartTime(dto.getUseStartTime());
        existingReservation.setUseEndTime(dto.getUseEndTime());
        existingReservation.setReason(dto.getReason());

        meetingRoomReservationRepository.save(existingReservation);

        return new ResultResponse<>(true);
    }

    @Override
    public ResultResponse<?> deleteReservation(ReservationDeleteDto dto) {
        MeetingRoomReservationId id = new MeetingRoomReservationId(dto.getReservationId(), dto.getCompanyCode(), dto.getMeetingRoomCode(), dto.getUserId(), dto.getUseDate());

        MeetingRoomReservation existingReservation = meetingRoomReservationRepository.findById(id);

        if (existingReservation == null) {
            return new ResultResponse<>(false, "ERR002", "해당 예약이 존재하지 않습니다.");
        }
        existingReservation.setStatus("D");
        meetingRoomReservationRepository.save(existingReservation);
        return new ResultResponse<>(true);
    }

    @Override
    public List<ReservationResult> dailyReservaionInfo(String companyCode, String useDate, String status) {

        List<MeetingRoomReservation> reservations = meetingRoomReservationRepository.findById_CompanyCodeAndId_UseDateAndStatus(companyCode,useDate,status);
        return reservations.stream()
                .map(this::convertToReservation)
                .collect(Collectors.toList());
    }
    private ReservationResult convertToReservation(MeetingRoomReservation reservation) {
        ReservationResult dto = new ReservationResult();
        String userName = userInfoRepository.findByUserId(reservation.getId().getUserId()).getUserName();
        dto.setReservationId(reservation.getId().getReservationId());
        dto.setCompanyCode(reservation.getId().getCompanyCode());
        dto.setMeetingRoomCode(reservation.getId().getMeetingRoomCode());
        dto.setUserId(reservation.getId().getUserId());
        dto.setUseDate(reservation.getId().getUseDate());
        dto.setUseStartTime(reservation.getUseStartTime());
        dto.setUseEndTime(reservation.getUseEndTime());
        dto.setReason(reservation.getReason());
        dto.setStatus(reservation.getStatus());
        dto.setUserName(userName);
        return dto;
    }




    /*

    ResultResponse<?> updateReservation(ReservationUpdateDto dto);
    @Override
    public ResultResponse<?> dailyReservaionInfo(ReservationDailyInfoDto dto) {

        List<MeetingRoomReservation> reservations = meetingRoomReservationRepository.findById_CompanyCodeAndId_UseDateAndStatus(dto.getCompanyCode(), dto.getUseDate(), "L");
        if (reservations.isEmpty()) {
            return new ResultResponse<>(false, "ERR003", "해당 날짜에 예약건이 존재하지 않습니다.", null);
        }

        return new ResultResponse<>(true, null, null, reservations);
    }

    */

}



