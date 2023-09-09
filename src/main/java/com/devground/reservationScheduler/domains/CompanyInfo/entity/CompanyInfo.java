package com.devground.reservationScheduler.domains.CompanyInfo.entity;


import com.devground.reservationScheduler.domains.MeetingRoomMst.entity.MeetingRoomMst;
import com.devground.reservationScheduler.domains.UserInfo.entity.UserInfo;
import com.devground.reservationScheduler.domains.base.BaseClass;
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
@Table(name = "CompanyInfo")
public class CompanyInfo extends BaseClass {

    @Id
    @Column(name = "CompanyCode", nullable = false, length = 10)
    private String companyCode;

    @Column(name = "CompanyName", nullable = false, length = 100)
    private String companyName;

    @Column(name = "UseYn")
    private Boolean useYn;

    //@OneToMany(mappedBy = "companyInfo")
    //private List<UserInfo> users;

    //@OneToMany(mappedBy = "companyInfo")
    //private List<MeetingRoomMst> meetingRooms;
}
