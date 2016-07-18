package com.work.myretail.dto;

public class PricingInsertTO {
int id=0;
String productName="";
String currency_code="";
double value=0.00d;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getCurrency_code() {
	return currency_code;
}
public void setCurrency_code(String currency_code) {
	this.currency_code = currency_code;
}
public double getValue() {
	return value;
}
public void setValue(double value) {
	this.value = value;
}


}
