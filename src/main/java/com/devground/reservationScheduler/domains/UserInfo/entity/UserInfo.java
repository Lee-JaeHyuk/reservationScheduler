package com.devground.reservationScheduler.domains.UserInfo.entity;

import com.devground.reservationScheduler.domains.base.BaseClass;
import com.devground.reservationScheduler.domains.CompanyInfo.entity.CompanyInfo;
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
@Table(name = "UserInfo")
public class UserInfo extends BaseClass {

    @Id
    @Column(name = "UserID")
    private Integer userId;

    @Column(name = "CompanyCode", length = 10)
    private String companyCode;

    @Column(name = "EmpNo", length = 10)
    private String empNo;

    @Column(name = "UserName", length = 300)
    private String userName;

    @Column(name = "LoginID", length = 30)
    private String loginId;

    @Column(name = "EmpStatus", length = 1)
    private String empStatus;

    @Column(name = "Email", length = 10)
    private String email;

    @Column(name = "UseYn")
    private Boolean useYn;

    //@ManyToOne
    //@JoinColumn(name = "CompanyCode", referencedColumnName = "CompanyCode")
    //private CompanyInfo companyInfo;


}
