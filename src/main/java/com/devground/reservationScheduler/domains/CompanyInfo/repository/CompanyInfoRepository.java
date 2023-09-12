package com.devground.reservationScheduler.domains.CompanyInfo.repository;

import com.devground.reservationScheduler.domains.CompanyInfo.entity.CompanyInfo;
import com.devground.reservationScheduler.domains.MeetingRoomReservaion.entity.MeetingRoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, String> {

    CompanyInfo findByCompanyCode(String companyCode);


}
