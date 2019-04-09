package br.com.uniliva.ebao.dto;

import java.io.Serializable;

public class FilterDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String status;
	private String date;
	
	
	
	public FilterDto(String status, String date) {
		this.status = status;
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "FilterDto [status=" + status + ", date=" + date + "]";
	}
	
	

}
