package com.work.myretail.dto;


public class IdentifierDataTO {

	String id_type="";
	String id="";
	String is_primary=null;;
	String source="";
	public String getId_type() {
		return id_type;
	}
	public void setId_type(String id_type) {
		this.id_type = id_type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public String getIs_primary() {
		return is_primary;
	}
	public void setIs_primary(String is_primary) {
		this.is_primary = is_primary;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
}
