package com.work.myretail.dto;

public class MyRetailOutputTO {
int id=0;
String name="";
PricingDataTO current_price=null;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public PricingDataTO getCurrent_price() {
	return current_price;
}
public void setCurrent_price(PricingDataTO current_price) {
	this.current_price = current_price;
}

}
