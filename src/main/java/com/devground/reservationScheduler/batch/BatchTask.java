package com.devground.reservationScheduler.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BatchTask implements Tasklet {


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        LocalDate today = LocalDate.now();
        if (today.getDayOfMonth() == 1) {
            // 여기에서 규칙적인 예약건을 생성하는 로직을 구현
            // 예를 들어, ds팀 주간보고 예약건을 생성하는 코드를 작성
            // 예약 생성 로직을 호출하는 서비스나 컴포넌트를 호출

            // 예약 생성이 완료되면 로그나 알림을 추가로 남길 수 있음
            System.out.println("규칙적인 예약건을 생성했습니다.");
        }

        return RepeatStatus.FINISHED;

    }
}
