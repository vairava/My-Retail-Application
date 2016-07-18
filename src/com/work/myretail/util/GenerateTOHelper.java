package com.work.myretail.util;

import java.net.UnknownHostException;

import com.mongodb.DBCollection;
import com.work.myretail.dao.MongoDBConnection;
import com.work.myretail.dto.PricingInsertTO;


public class GenerateTOHelper {

	public static void main(String[] args) throws UnknownHostException {
		
		DBCollection col=MongoDBConnection.getDBConnection();
		PricingInsertTO pricingTo=new PricingInsertTO();
		pricingTo.setId(13860428);
		pricingTo.setProductName("BIG LEBOWSKI, THE Blu-ray");;
		pricingTo.setValue(99.10);
		pricingTo.setCurrency_code("RUPEE");
		//MongoDBConnection.createData(col, pricingTo);
		//MongoDBConnection.insertData(col, pricingTo);
		//MongoDBConnection.deleteData(col, pricingTo.getId());
		MongoDBConnection.viewAllData(col);
	}
}
