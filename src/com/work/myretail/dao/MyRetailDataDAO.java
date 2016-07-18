package com.work.myretail.dao;

import java.net.UnknownHostException;
import java.util.List;

import org.apache.log4j.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.work.myretail.dto.FinalDataTO;
import com.work.myretail.dto.MyRetailOutputTO;
import com.work.myretail.dto.PricingInsertTO;
import com.work.myretail.helper.HTTPClientHelper;
import com.work.myretail.processor.MyRetailProcess;
import com.work.myretail.util.ApplicationConstants;
import com.work.myretail.util.MarshallingUtil;

public class MyRetailDataDAO {
	private static final  Logger LOGGER = Logger.getLogger(MyRetailProcess.class);
	/**
	 * DAO method to get Data For ProductId
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public FinalDataTO getDataForProductId(int productId) throws Exception{
		LOGGER.debug("entering into getDataForProductId()--->>");
		HTTPClientHelper helper=new HTTPClientHelper();
		String jsonData="";
		FinalDataTO finalTo=null;
		String finalUrl=ApplicationConstants.URL_FIRST_PART+productId+ApplicationConstants.URL_SECOND_PART;
		jsonData=helper.sendGet(finalUrl);
		
		if((!"".equalsIgnoreCase(jsonData) && jsonData!=null)){
			finalTo=(FinalDataTO)MarshallingUtil.unmarshalFromJSON(jsonData, FinalDataTO.class);
		}
		LOGGER.debug("exiting into getDataForProductId()<<--");
		return finalTo;
	}
	/**
	 * method that processes manupulations from nosql data
	 * @param finalTo
	 * @return
	 * @throws UnknownHostException
	 */
	public  BasicDBObject processNoSqlManupulation(MyRetailOutputTO finalTo) throws UnknownHostException{
		LOGGER.debug("entering into processNoSqlManupulation()--->>");
		DBCollection dbColl=MongoDBConnection.getDBConnection();
		BasicDBObject finalResult=getPricingFromDB(finalTo.getId(),dbColl);
		LOGGER.debug("entering into processNoSqlManupulation()--->>");
		return finalResult;
	}
	/**
	 * Method that makes mongodb call to update pricing
	 * @param pricingTo
	 * @param dbColl
	 * @return
	 */
	public String updatePricingForProduct(PricingInsertTO pricingTo,DBCollection dbColl){
		LOGGER.debug("entering into updatePricingForProduct()--->>");
			MongoDBConnection.insertData(dbColl,pricingTo);
			LOGGER.debug("entering into updatePricingForProduct()--->>");
		return ApplicationConstants.UPDATE_SUCCESS;
	}
	/**
	 * method to get the pricing value for the prod id from mongo db
	 * @param id
	 * @param col
	 * @param finalTo
	 * @return
	 */
	public BasicDBObject getPricingFromDB(int id,DBCollection col){
		LOGGER.debug("entering into getPricingFromDB()--->>");
		BasicDBObject result=null;
		List<BasicDBObject> resultList= MongoDBConnection.viewData(col,id);
		if(!resultList.isEmpty()){
				result=resultList.get(0);
				//finalTo=manuplateResults(finalTo,result);
		}
		LOGGER.debug("entering into getPricingFromDB()--->>");
		return result;
	}
	
}
