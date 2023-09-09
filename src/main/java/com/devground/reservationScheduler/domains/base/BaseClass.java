package com.devground.reservationScheduler.domains.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseClass extends BaseTimeEntity {

    @Column(columnDefinition = "boolean default true")
    private boolean isUsed = true;

    @Column
    private String inUserId;

    @Column
    private String modiUserId;

}
