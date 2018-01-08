package com.xc.consumer.interfaces.web.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xc.consumer.application.service.TestService;

@RestController
public class HomeController {
	@Autowired
	TestService testService;

	@GetMapping(value = "")
	public String index() {
		return testService.hiService() + " ribbon";
	}

	@GetMapping(value = "hi")
	public String hi() {
		return testService.hiService() + " ribbon";
	}
	@GetMapping("/get/{id}")
	public Object get(@PathVariable Long id) {
		User user = testService.get(id);
		return user;
	}
}
