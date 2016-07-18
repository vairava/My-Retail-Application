package com.work.myretail.processor;

import java.net.UnknownHostException;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.work.myretail.dao.MongoDBConnection;
import com.work.myretail.dao.MyRetailDataDAO;
import com.work.myretail.dto.FinalDataTO;
import com.work.myretail.dto.MyRetailOutputTO;
import com.work.myretail.dto.PricingDataTO;
import com.work.myretail.dto.PricingInsertTO;
import com.work.myretail.exception.MyRetailException;
import com.work.myretail.util.ApplicationConstants;

public class MyRetailProcess {
	private static final  Logger LOGGER = Logger.getLogger(MyRetailProcess.class);
	/**
	 * Method that processes myretail operations to retrieve information
	 * @param prodId
	 * @param outPutTO
	 * @return final output to show user
	 * @throws Exception
	 */
	public MyRetailOutputTO processMyRetailData(int prodId,MyRetailOutputTO outPutTO) throws MyRetailException{
		LOGGER.debug("entering processMyRetailData()-->>");
		MyRetailDataDAO dataDao=new MyRetailDataDAO();
		try{
		FinalDataTO finalTo=dataDao.getDataForProductId(prodId);
		if(finalTo!=null){
			String name=finalTo.getProduct_composite_response().getItems().get(0).getGeneral_description();
			outPutTO.setName(name);
		}
		Gson gson=new Gson();
		LOGGER.debug("finalTo-->>"+gson.toJson(finalTo));
		BasicDBObject result=dataDao.processNoSqlManupulation(outPutTO);
		outPutTO=manuplateResults(outPutTO,result);
		}catch(Exception e){
			throw new MyRetailException("Erorr processing processMyRetailData()-->",e);
		}
		LOGGER.debug("exiting processMyRetailData()<<--");
		return outPutTO;
	}
	/**
	 * method that manupulates data to shown output from the mondodb result
	 * @param finalTo
	 * @param result
	 * @return
	 */
	public MyRetailOutputTO manuplateResults( MyRetailOutputTO finalTo,BasicDBObject result){
		LOGGER.debug("entering manuplateResults()-->>");
		String currencyValue=result.getString(ApplicationConstants.CURRENCY_CODE);
		int value=result.getInt(ApplicationConstants.VALUE);
		PricingDataTO pricingTo=new PricingDataTO();
		pricingTo.setCurrency_code(currencyValue);
		pricingTo.setValue(value);
		finalTo.setCurrent_price(pricingTo);
		LOGGER.debug("exiting manuplateResults()<<--");
		return finalTo;
	}
	/**
	 * method that process pricing update
	 * @param prodId
	 * @param pricingTO
	 * @return response output
	 * @throws Exception
	 */
	public String processPricingUpdate(int prodId,PricingDataTO pricingTO) throws MyRetailException{
		LOGGER.debug("entering processPricingUpdate()-->>");
		MyRetailDataDAO dataDao=new MyRetailDataDAO();
		PricingInsertTO pricingInsert=new PricingInsertTO();
		String response="";
		try{
			pricingInsert.setId(prodId);
			pricingInsert.setCurrency_code(pricingTO.getCurrency_code());
			pricingInsert.setValue(pricingTO.getValue());
			DBCollection dbColl = MongoDBConnection.getDBConnection();
			boolean isPresent=validateproductId(pricingInsert,dbColl);
			LOGGER.debug("Is ID found?--->>>"+isPresent);
			if(isPresent){
				response=dataDao.updatePricingForProduct(pricingInsert,dbColl);
			}
			else{
				return ApplicationConstants.PRODUCT_ID_MISS_ERROR;
			}
		
		}
		catch(Exception e){
			LOGGER.debug("Failed to update pricing-->>>");
			throw new MyRetailException("Failed to update pricing-->>>",e);
		}
		LOGGER.debug("exiting processPricingUpdate()<<--");
		return response;
	}
	/**
	 * method to validate product id before updating pricing
	 * @param insertTo
	 * @param dbColl
	 * @return true or false if prod id is present or not.
	 */
	public boolean validateproductId(PricingInsertTO insertTo,DBCollection dbColl){
		LOGGER.debug("entering validateproductId()-->>");
			List<BasicDBObject> resultList=MongoDBConnection.viewData(dbColl,insertTo.getId());
			if(resultList.isEmpty()){
				return false;
			}
			else{
				insertTo.setProductName(resultList.get(0).getString(ApplicationConstants.PRODUCT_NAME));
				LOGGER.debug(resultList.get(0).getString(ApplicationConstants.PRODUCT_NAME));
			}
			LOGGER.debug("exiting validateproductId()<<--");
		return true;
		
	}
	
	public String setTestData(PricingInsertTO pricngTO) throws UnknownHostException{
		LOGGER.debug("entering setTestData()-->>");
		DBCollection col=MongoDBConnection.getDBConnection();
		MyRetailDataDAO dao=new MyRetailDataDAO();
		String response="";
		BasicDBObject pricingData=dao.getPricingFromDB(pricngTO.getId(),col);
		if(pricingData!=null){
			response=ApplicationConstants.PRODUCT_ID_EXIST;
		}else{
			response=MongoDBConnection.createData(col, pricngTO);
			MongoDBConnection.viewAllData(col);
		}
		
		LOGGER.debug("exiting setTestData()<<--");
		return response;
	}
}
