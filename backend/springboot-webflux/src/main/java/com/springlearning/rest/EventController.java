package com.springlearning.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springlearning.service.EventService;
import com.springlearning.model.Event;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1")
public class EventController {
	
	@Autowired
	EventService eventService;

	@GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Event> events() {
		return eventService.getEvents();
	}
}
