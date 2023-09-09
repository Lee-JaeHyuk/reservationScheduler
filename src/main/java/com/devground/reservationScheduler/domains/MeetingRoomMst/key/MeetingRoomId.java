package com.devground.reservationScheduler.domains.MeetingRoomMst.key;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeetingRoomId implements Serializable {
    private String companyCode;
    private String meetingRoomCode;
}
