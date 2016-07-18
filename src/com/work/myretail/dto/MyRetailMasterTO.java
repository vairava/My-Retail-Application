package com.work.myretail.dto;

import java.util.List;

public class MyRetailMasterTO {

	List<RequestAttributesTO> request_attributes=null;
	List<ItemsDataTO> items=null;
	public List<RequestAttributesTO> getRequest_attributes() {
		return request_attributes;
	}
	public void setRequest_attributes(List<RequestAttributesTO> request_attributes) {
		this.request_attributes = request_attributes;
	}
	public List<ItemsDataTO> getItems() {
		return items;
	}
	public void setItems(List<ItemsDataTO> items) {
		this.items = items;
	}
	
}
