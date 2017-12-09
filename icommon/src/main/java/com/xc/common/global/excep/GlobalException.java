package com.xc.common.global.excep;

public class GlobalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GlobalException() {
		super();
	}

	public GlobalException(String message, Throwable cause) {
		super(message, cause);
	}

	public GlobalException(String message) {
		super(message);
	}

	public GlobalException(Throwable cause) {
		super(cause);
	}

}
