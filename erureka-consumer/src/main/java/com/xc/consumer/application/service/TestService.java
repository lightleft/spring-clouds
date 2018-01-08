package com.xc.consumer.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xc.consumer.interfaces.web.home.User;

@Service
public class TestService {
	@Autowired
	RestTemplate restTemplate;
	@Value("${service.base.name}")
	private String basePath;

	@HystrixCommand(fallbackMethod = "fallhiService", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "15000") })
	public String hiService() {
		return restTemplate.getForObject("http://" + basePath, String.class);
	}

	public String fallhiService() {
		return "this hystrixError";
	}

	public User get(Long id) {
		return restTemplate.getForObject("http://" + basePath + "/get/{id}", User.class, id);
	}
}
