package com.springlearning.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.springlearning.service.VehicleSpeedService;
import com.springlearning.model.VehicleSpeedEvent;

import reactor.core.publisher.Mono;

@Component
public class RequestHandler {
	
	@Autowired
	public VehicleSpeedService vehicleSpeedService;

	public Mono<ServerResponse> monitorVehicleSpeed(ServerRequest request) {
	        return ServerResponse.ok()
	                .contentType(MediaType.TEXT_EVENT_STREAM)
	                .body(vehicleSpeedService.monitor(), VehicleSpeedEvent.class);
	    }

}
