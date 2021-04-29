package com.goldrush.dto;

public class ResponseDTO {
	private int result;
	private String message;
	private Object obj;
	
	public ResponseDTO(int result, String message, Object obj) {
		super();
		this.result = result;
		this.message = message;
		this.obj = obj;
	}
	public ResponseDTO(int result, String message) {
		super();
		this.result = result;
		this.message = message;
	}
	public ResponseDTO(int result, Object obj) {
		super();
		this.result = result;
		this.obj = obj;
	}
	public ResponseDTO() {
		super();
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "ResponseDTO [result=" + result + ", message=" + message + ", obj=" + obj + "]";
	}
	
}
