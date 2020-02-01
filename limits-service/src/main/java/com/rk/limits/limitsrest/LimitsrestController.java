package com.rk.limits.limitsrest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rk.limits.configurationproperties.Configuration;
import com.rk.limits.model.LimitConfiguration;

@RestController
public class LimitsrestController {
	@Autowired
	Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration retrievelLimitsFromConfigurations() {
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimun());
	}

	@GetMapping("/fault-tolerance-example")

	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")

	public LimitConfiguration retrieveConfiguration() {

		throw new RuntimeException("Not available");

	}

	public LimitConfiguration fallbackRetrieveConfiguration() {

		return new LimitConfiguration(02, 2);

	}

}
