package com.xc.consumer.application.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "service-base", fallback = TestServiceImpl.class)
public interface TestService {
	@GetMapping(value = "")
	public String hiService();
}