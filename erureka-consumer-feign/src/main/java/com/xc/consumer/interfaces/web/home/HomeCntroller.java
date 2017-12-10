package com.xc.consumer.interfaces.web.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xc.consumer.application.service.TestService;

@RestController
public class HomeCntroller {
	@Autowired
	TestService testService;

	@GetMapping(value = "")
	public String index() {
		return testService.hiService() + " feign";
	}

	@GetMapping(value = "hi")
	public String hi() {
		return testService.hiService() + " feign";
	}
}
