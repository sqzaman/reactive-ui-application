package com.springlearning.service;

import com.springlearning.model.Event;
import reactor.core.publisher.Flux;

public interface EventService {
	Flux<Event> getEvents();
}
