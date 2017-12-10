package com.xc.base.interfaces.web.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.xc.base.interfaces.web.conf.interceptor.LoggerInfoInterceptor;

@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInfoInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
