package com.devground.reservationScheduler.domains.MeetingRoomReservaion.entity;

import com.devground.reservationScheduler.domains.MeetingRoomMst.entity.MeetingRoomMst;
import com.devground.reservationScheduler.domains.base.BaseClass;
import com.devground.reservationScheduler.domains.MeetingRoomReservaion.key.MeetingRoomReservationId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MeetingRoomReservation")
public class MeetingRoomReservation extends BaseClass {

    @EmbeddedId
    private MeetingRoomReservationId id;

    @Column(name= "UseStartTime",length = 4,nullable = false)
    private String useStartTime;

    @Column(name = "UseEndTime", length = 4,nullable = false)
    private String useEndTime;

    @Column(name = "Reason",nullable = true)
    private String reason;

    @Column(name = "Status",nullable = true)
    private String status;


    //@ManyToOne
    //@JoinColumns({
    //        @JoinColumn(name = "CompanyCode", referencedColumnName = "CompanyCode", insertable = false, updatable = false),
    //        @JoinColumn(name = "MeetingRoomCode", referencedColumnName = "MeetingRoomCode", insertable = false, updatable = false)
    //})
    //private MeetingRoomMst meetingRoomMst;


}
