package com.xc.common.global.web.res;

import static com.xc.common.global.web.res.ResultType.ERROR;
import static com.xc.common.global.web.res.ResultType.SUCCESS;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;


public class ResultVO {
	private String status;
	private String msg;
	private Object data;

	private ResultVO(ResultType type) {
		this(type, null);
	}

	private ResultVO(ResultType type, Object data) {
		Assert.notNull(type, "type 是必须的");
		this.setStatus(type.getCode());
		this.setMsg(type.getMsg());
		this.setData(data);
	}

	private ResultVO(String status, String msg) {
		this.setStatus(status);
		this.setMsg(msg);
		this.setData(null);
	}

	private ResultVO(String status, String msg, Object data) {
		this.setStatus(status);
		this.setMsg(msg);
		this.setData(data);
	}

	public String getStatus() {
		return status;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}

	private void setStatus(String status) {
		Assert.notNull(status, "status 是必须的");
		this.status = status;
	}

	private void setMsg(String msg) {
		Assert.notNull(msg, "msg 是必须的");
		this.msg = msg;
	}

	private void setData(Object data) {
		this.data = data;
	}

	private static final ResultVO SUCCUSS_RES = new ResultVO(SUCCESS);
	private static final ResultVO ERRER_RES = new ResultVO(ERROR);

	private static class ResultStore {
		static final Map<String, ResultVO> stroe = new HashMap<>();
	}

	private static ResultVO putResult(String code, String msg) {
		ResultVO res = new ResultVO(code, msg);
		ResultStore.stroe.put(code, res);
		return res;
	}

	public static ResultVO getSuccess(Object data) {
		if (data == null) {
			return SUCCUSS_RES;
		}
		return new ResultVO(SUCCESS, data);
	}

	public static ResultVO getError(Object data) {
		if (data == null) {
			return ERRER_RES;
		}
		return new ResultVO(ERROR, data);
	}

	public static ResultVO get(String code, String msg) {
		ResultVO res = ResultStore.stroe.get(code);
		if (res == null) {
			res = putResult(code, msg);
		}
		return res;
	}

	public static ResultVO get(String code, String msg, Object data) {
		if (data == null) {
			return get(code, msg);
		}
		return new ResultVO(code, msg, data);
	}
}
