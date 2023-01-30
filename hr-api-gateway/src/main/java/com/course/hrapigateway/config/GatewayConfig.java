package com.course.hrapigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/payments/**").uri("lb://HR-PAYROLL"))
				.route(r -> r.path("/workers/**").uri("lb://HR-WORKER"))
				.route(r -> r.path("/workers").uri("lb://HR-WORKER"))
				.route(r -> r.path("/users/**").uri("lb://HR-USER"))
				.build();
	}

}