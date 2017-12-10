package com.xc.base.interfaces.web.conf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInfoInterceptor extends HandlerInterceptorAdapter {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// HandlerMethod handlerMethod = (HandlerMethod) handler;
		log.info("{} 调用成功", request.getRequestURI());
	}

}
