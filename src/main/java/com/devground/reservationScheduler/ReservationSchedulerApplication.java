package com.devground.reservationScheduler;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableBatchProcessing
public class ReservationSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationSchedulerApplication.class, args);
	}

}
