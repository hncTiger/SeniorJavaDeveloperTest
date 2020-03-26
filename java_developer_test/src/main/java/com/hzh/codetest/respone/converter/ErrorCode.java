package com.hzh.codetest.respone.converter;

public enum ErrorCode {
	SUCCESS(200, "成功"), //正常返回数据
	SERVER_ERROR(10000, "维护中"), //全局异常
	;//

	private int code;
	private String msg;

	ErrorCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
