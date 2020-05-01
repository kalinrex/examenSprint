package com.example.demo.Enums;

public enum ResponseCode {
	EXITOSO(0), ERROR(-1);
	
	private ResponseCode(int code) {
		this.code = code;
	}
	public int getResponse() {
		return code;
	}
	private int code;
}
