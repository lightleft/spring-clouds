package com.xc.base;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.xc.base.infrastructure.persistence.mapper.UserMapper;
import com.xc.base.infrastructure.persistence.model.User;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceBaseApplication {

	@Autowired
	private UserMapper userMapper;

	@PostConstruct
	public void init() {
		User user = new User();
		user.setName("zs");
		user.setAge(13);
		userMapper.save(user);
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceBaseApplication.class, args);
	}
}
