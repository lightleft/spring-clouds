package com.xc.common.global.web.res;

public enum ResultType {
	SUCCESS("0000", "ok"), ERROR("9999", "error");

	private String code;
	private String msg;

	private ResultType(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
