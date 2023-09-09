package com.devground.reservationScheduler.domains.MeetingRoomMst.entity;

import com.devground.reservationScheduler.domains.CompanyInfo.entity.CompanyInfo;
import com.devground.reservationScheduler.domains.MeetingRoomReservaion.entity.MeetingRoomReservation;
import com.devground.reservationScheduler.domains.base.BaseClass;

import com.devground.reservationScheduler.domains.MeetingRoomMst.key.MeetingRoomId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MeetingRoomMst")
public class MeetingRoomMst extends BaseClass {

    @EmbeddedId
    private MeetingRoomId id;

    @Column(name = "MeetingRoomName", length = 100)
    private String meetingRoomName;

    @Column(name = "MeetingRoomInfo", length = 50)
    private String meetingRoomInfo;

    @Column(name = "UseYn", length = 1)
    private String useYn;


   // @ManyToOne
   // @JoinColumn(name = "CompanyCode", insertable = false, updatable = false)
   // private CompanyInfo companyInfo;

    //@OneToMany(mappedBy = "meetingRoomMst")
    //private List<MeetingRoomReservation> reservations;



}
