package com.work.myretail.dto;

public class ProcessStatusHelperTO {
	
	boolean is_ready=false;
	String operation_description="";
	String operation_code="";
	
	
	public boolean isIs_ready() {
		return is_ready;
	}
	public void setIs_ready(boolean is_ready) {
		this.is_ready = is_ready;
	}
	public String getOperation_description() {
		return operation_description;
	}
	public void setOperation_description(String operation_description) {
		this.operation_description = operation_description;
	}
	public String getOperation_code() {
		return operation_code;
	}
	public void setOperation_code(String operation_code) {
		this.operation_code = operation_code;
	}
}
