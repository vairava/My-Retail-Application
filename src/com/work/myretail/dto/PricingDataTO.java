package com.work.myretail.dto;

public class PricingDataTO {
double value=0.0d;
String currency_code="";
public String getCurrency_code() {
	return currency_code;
}
public double getValue() {
	return value;
}
public void setValue(double value) {
	this.value = value;
}
public void setCurrency_code(String currency_code) {
	this.currency_code = currency_code;
}

}
