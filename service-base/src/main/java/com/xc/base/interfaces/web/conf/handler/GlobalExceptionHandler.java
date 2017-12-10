package com.xc.base.interfaces.web.conf.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import com.xc.common.global.web.res.ResultVO;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(Exception.class)
	public ResultVO handler(Exception e, HandlerMethod method, HttpServletRequest request) {
		log.error("{} 调用失败", request.getRequestURI(), e);
		return ResultVO.getError(null);
	}

}
