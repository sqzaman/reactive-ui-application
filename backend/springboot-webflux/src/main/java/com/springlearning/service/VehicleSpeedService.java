package com.springlearning.service;


import com.springlearning.model.VehicleSpeedEvent;
import reactor.core.publisher.Flux;

public interface VehicleSpeedService {
	
    Flux<VehicleSpeedEvent> monitor();

}
