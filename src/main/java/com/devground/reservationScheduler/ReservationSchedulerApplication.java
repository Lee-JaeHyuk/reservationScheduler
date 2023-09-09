package com.devground.reservationScheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ReservationSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationSchedulerApplication.class, args);
	}

}
