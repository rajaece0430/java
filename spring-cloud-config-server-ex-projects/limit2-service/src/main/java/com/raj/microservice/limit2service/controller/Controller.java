package com.raj.microservice.limit2service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.microservice.limit2service.bean.Limits;
import com.raj.microservice.limit2service.config.Configuration;

@RestController
public class Controller {
	
	@Autowired
	public Configuration config;
	
	@GetMapping("limits2")
	public Limits retriveLimit() {
		return new Limits(config.getMinimum(),config.getMaximum());
	}
}
