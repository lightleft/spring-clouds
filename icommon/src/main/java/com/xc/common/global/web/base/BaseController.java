package com.xc.common.global.web.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xc.common.global.web.res.ResultVO;

public class BaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	protected void info(String msg, Object... objs) {
		log.info(msg, objs);
	}

	protected void warn(String msg, Object... objs) {
		log.warn(msg, objs);
	}

	protected void error(String msg, Object... objs) {
		log.error(msg, objs);
	}

	protected ResultVO result(Object data) {
		return ResultVO.getSuccess(data);
	}

	protected ResultVO result() {
		return ResultVO.getSuccess(null);
	}
}
