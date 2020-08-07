package com.springlearning.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicleSpeedEvent {

	private Vehicle vehicle;
    private int speed;
	private LocalDateTime time;  
	private boolean overSpeed;	
	
	public VehicleSpeedEvent(Vehicle vehicle, int speed, LocalDateTime time) {
		this.vehicle = vehicle;
		this.speed = speed;
		this.time = time;
    	if (speed > 70) {
			this.overSpeed = true;
		}
	}	
}
