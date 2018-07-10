package com.ipengshan.shanshanweb.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultJson implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String status;
	private String resons;
//	@JsonProperty(defaultValue="not data")
	private Object data="no more data ";
//	@JsonProperty(defaultValue="not message")
	private String other="no message";

	public ResultJson() {
		super();
	}

	public ResultJson(String status, String resons, Object data, String other) {
		super();
		this.status = status;
		this.resons = resons;
		this.data = data;
		this.other = other;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResons() {
		return resons;
	}

	public void setResons(String resons) {
		this.resons = resons;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ResultJson [status=" + status + ", resons=" + resons
				+ ", data=" + data + ", other=" + other + "]";
	}

	
	
	

}
