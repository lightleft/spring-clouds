package com.xc.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xc.base.infrastructure.persistence.mapper.UserMapper;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceBaseApplication {

	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/get/{id}")
	public Object getById(@PathVariable Long id) {
		return userMapper.getById(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceBaseApplication.class, args);
	}
}
