package com.work.myretail.dto;

import java.util.List;

public class ItemsDataTO {

	List<IdentifierDataTO> identifier=null;
	String relation="";
	String relation_description="";
	String data_page_link="";
	int imn_identifier=0;
	boolean is_orderable=false;
	boolean is_sellable=false;
	String general_description="";
	boolean is_circular_publish=false;
	List<ProcessStatusDataTO> business_process_status=null;
	String dpci="";
	int department_id=0;
	int class_id=0;
	int item_id=0;
	ValueTypeDataTO online_description=null;
	ValueTypeDataTO store_description=null;
	List<AlternateDescriptionTO> alternate_description=null;
	public List<IdentifierDataTO> getIdentifier() {
		return identifier;
	}
	public void setIdentifier(List<IdentifierDataTO> identifier) {
		this.identifier = identifier;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getRelation_description() {
		return relation_description;
	}
	public void setRelation_description(String relation_description) {
		this.relation_description = relation_description;
	}
	public String getData_page_link() {
		return data_page_link;
	}
	public void setData_page_link(String data_page_link) {
		this.data_page_link = data_page_link;
	}
	public int getImn_identifier() {
		return imn_identifier;
	}
	public void setImn_identifier(int imn_identifier) {
		this.imn_identifier = imn_identifier;
	}
	public boolean isIs_orderable() {
		return is_orderable;
	}
	public void setIs_orderable(boolean is_orderable) {
		this.is_orderable = is_orderable;
	}
	public boolean isIs_sellable() {
		return is_sellable;
	}
	public void setIs_sellable(boolean is_sellable) {
		this.is_sellable = is_sellable;
	}
	public String getGeneral_description() {
		return general_description;
	}
	public void setGeneral_description(String general_description) {
		this.general_description = general_description;
	}
	public boolean isIs_circular_publish() {
		return is_circular_publish;
	}
	public void setIs_circular_publish(boolean is_circular_publish) {
		this.is_circular_publish = is_circular_publish;
	}
	public List<ProcessStatusDataTO> getBusiness_process_status() {
		return business_process_status;
	}
	public void setBusiness_process_status(
			List<ProcessStatusDataTO> business_process_status) {
		this.business_process_status = business_process_status;
	}
	public String getDpci() {
		return dpci;
	}
	public void setDpci(String dpci) {
		this.dpci = dpci;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public ValueTypeDataTO getOnline_description() {
		return online_description;
	}
	public void setOnline_description(ValueTypeDataTO online_description) {
		this.online_description = online_description;
	}
	public ValueTypeDataTO getStore_description() {
		return store_description;
	}
	public void setStore_description(ValueTypeDataTO store_description) {
		this.store_description = store_description;
	}
	public List<AlternateDescriptionTO> getAlternate_description() {
		return alternate_description;
	}
	public void setAlternate_description(
			List<AlternateDescriptionTO> alternate_description) {
		this.alternate_description = alternate_description;
	}
	
	
	
}
