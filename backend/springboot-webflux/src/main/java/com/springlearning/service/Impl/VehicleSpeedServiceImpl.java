package com.springlearning.service.Impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.stream.Stream;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import com.springlearning.service.VehicleSpeedService;
import com.springlearning.model.Vehicle;
import com.springlearning.model.VehicleSpeedEvent;
import reactor.core.publisher.Flux;

@Service
public class VehicleSpeedServiceImpl implements VehicleSpeedService {

	@Override
	public Flux<VehicleSpeedEvent> monitor() {

		Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
		Flux<VehicleSpeedEvent> events = Flux.fromStream(Stream.generate(() ->

		new VehicleSpeedEvent(new Vehicle(
				String.format("%s%s%s", RandomStringUtils.randomNumeric(1),
						RandomStringUtils.randomAlphabetic(10).toUpperCase(), RandomStringUtils.randomNumeric(6)),
				RandomStringUtils.randomAlphabetic(6).toUpperCase()), getSpeed(30, 100), LocalDateTime.now())

		));

		return Flux.zip(events, interval, (key, value) -> key);

	}

	private int getSpeed(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

}
