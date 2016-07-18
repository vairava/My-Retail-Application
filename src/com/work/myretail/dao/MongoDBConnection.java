package com.work.myretail.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.work.myretail.dto.PricingInsertTO;
import com.work.myretail.util.ApplicationConstants;

public class MongoDBConnection {
	private static final  Logger LOGGER = Logger.getLogger(MongoDBConnection.class);
	public static DBCollection getDBConnection() throws UnknownHostException{
		MongoClient mongoClient = new MongoClient("localhost",27017);
		DB db = mongoClient.getDB("myRetailDB");
		List<String> dbs = mongoClient.getDatabaseNames();
		LOGGER.debug("DBs-->>"+dbs);
		DBCollection col = db.getCollection("pricingData");
		LOGGER.debug("collections-->>"+col);
		return col;
	}
	
	public static void insertData(DBCollection col,PricingInsertTO pricingTo ){
		DBObject query = BasicDBObjectBuilder.start().add("id", 13860428).get();
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("id", pricingTo.getId());
		docBuilder.append("productname", pricingTo.getProductName());
 		docBuilder.append("value", pricingTo.getValue());
		docBuilder.append("currency_code", pricingTo.getCurrency_code());
		DBObject dbObj=docBuilder.get();
		WriteResult result=col.update(query,dbObj);
		
	}
	public static String createData(DBCollection col,PricingInsertTO pricingTo ){
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append(ApplicationConstants.PRODUCT_ID, pricingTo.getId());
		docBuilder.append(ApplicationConstants.PRODUCT_NAME, pricingTo.getProductName());
		docBuilder.append(ApplicationConstants.VALUE, pricingTo.getValue());
		docBuilder.append(ApplicationConstants.CURRENCY_CODE, pricingTo.getCurrency_code());
		DBObject dbObj=docBuilder.get();
		WriteResult result=col.insert(dbObj);
		return ApplicationConstants.INSERT_SUCCESS;
	}
	
	public static List<BasicDBObject> viewData(DBCollection col,int id){
		DBObject query = BasicDBObjectBuilder.start().add("id", id).get();
		DBCursor cursor = col.find(query);
		List<BasicDBObject> resultList=new ArrayList<BasicDBObject>();
		
		while(cursor.hasNext()){
			BasicDBObject readTO=(BasicDBObject)cursor.next();
			resultList.add(readTO);
			LOGGER.debug(readTO);
		}
		return resultList;
	}
	public static void viewAllData(DBCollection col){
		DBObject query = BasicDBObjectBuilder.start().get();
		DBCursor cursor = col.find(query);
		
		while(cursor.hasNext()){
			BasicDBObject readTO=(BasicDBObject)cursor.next();
			LOGGER.debug(readTO);
		}
		
		
		}
	public static void deleteData(DBCollection col,int id){
		DBObject query = BasicDBObjectBuilder.start().add("id", id).get();
		WriteResult result=col.remove(query);
	}
}