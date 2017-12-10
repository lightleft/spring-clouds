package com.xc.consumer.application.service;

import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl implements TestService{

	@Override
	public String hiService() {
		return "this feign error";
	}

}
