package com.devground.reservationScheduler.domains.MeetingRoomReservaion.key;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeetingRoomReservationId implements Serializable {


    @Column(name = "ReservationId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    private String companyCode;
    private String meetingRoomCode;
    private Integer userId;
    private String useDate;


}
