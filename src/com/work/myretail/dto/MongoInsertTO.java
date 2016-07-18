package com.work.myretail.dto;

public class MongoInsertTO {

	int id=0;
	String prodName="";
	double value=0.0d;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getCurrencycode() {
		return currencycode;
	}
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}
	String currencycode="";
	
}
