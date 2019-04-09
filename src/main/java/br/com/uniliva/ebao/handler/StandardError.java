package br.com.uniliva.ebao.handler;

import java.io.Serializable;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer httpCode;
	private String message;
	
	public StandardError(Integer httpCode, String message) {
		this.httpCode = httpCode;
		this.message = message;
	}

	public Integer getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "StandardError [httpCode=" + httpCode + ", message=" + message + "]";
	}
}
