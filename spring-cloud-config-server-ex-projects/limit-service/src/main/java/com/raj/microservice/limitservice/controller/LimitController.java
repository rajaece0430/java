package com.raj.microservice.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.microservice.limitservice.bean.Limits;
import com.raj.microservice.limitservice.config.Configuration;

@RestController
public class LimitController {
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	public Limits retriveLimits() {
		return new Limits(config.getMinimum(),config.getMaximum());
		//return new Limits(1,1000);
	}
	
}
