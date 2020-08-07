package com.springlearning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import com.springlearning.rest.RequestHandler;

@Configuration
public class RequestDispatcher {

	@Bean
	RouterFunction<?> routes(RequestHandler requestHandler) {
		return RouterFunctions.route(RequestPredicates.GET("/api/v1/monitor/speed"),
				requestHandler::monitorVehicleSpeed);

	}

}
