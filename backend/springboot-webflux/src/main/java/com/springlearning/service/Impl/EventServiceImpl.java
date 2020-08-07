package com.springlearning.service.Impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.springlearning.service.EventService;
import com.springlearning.model.Event;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@Service
public class EventServiceImpl implements EventService {

	@Override
	public Flux<Event> getEvents() {
		Flux<Event> eventFlux = Flux.fromStream(
				Stream.generate(() ->
						new Event(System.currentTimeMillis(),
								RandomStringUtils.randomAlphanumeric(17).toUpperCase(), 
								LocalDateTime.now()))
		);

		Flux<Long> durationFlux = Flux.interval(Duration.ofSeconds(1));

		return Flux.zip(eventFlux, durationFlux).map(Tuple2::getT1);
	}

}
