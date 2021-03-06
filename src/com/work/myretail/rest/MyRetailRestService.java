package com.work.myretail.rest;

import java.net.UnknownHostException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.work.myretail.dto.MyRetailOutputTO;
import com.work.myretail.dto.PricingInsertTO;
import com.work.myretail.exception.MyRetailException;
import com.work.myretail.processor.MyRetailProcess;
import com.work.myretail.util.ApplicationConstants;

@Path("/MyRetail")
public class MyRetailRestService
{
	private static final  Logger LOGGER = Logger.getLogger(MyRetailRestService.class);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products/{prodId}")
    public Response getProductDetails(@PathParam("prodId") int prodId,
                           @DefaultValue("1") @QueryParam("version") int version) throws MyRetailException
    {
    	LOGGER.debug("Entering into getProductDetails()--->>");
    	MyRetailProcess retailProcessor=new MyRetailProcess();
    	MyRetailOutputTO finalOutPut=new MyRetailOutputTO();
    	finalOutPut.setId(prodId);
       if(version==1){
    	   //calling processor method to fetch prod data
    	   finalOutPut=retailProcessor.processMyRetailData(prodId,finalOutPut);
       }
       else{
    	   LOGGER.error("INVALID VERSION: "+version);
       }
       LOGGER.debug("Exiting into getProductDetails()<<--");
        return Response.status(200).entity(finalOutPut).build();	
    	
    }  
	
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products/{prodId}")
    public String updatePricingDetails(@PathParam("prodId") int prodId,MyRetailOutputTO pricingTO,
                           @DefaultValue("1") @QueryParam("version") int version) throws Exception
    {
    	LOGGER.debug("Entering into updatePricingDetails()--->>");
    	String response="";
    	MyRetailProcess retailProcessor=new MyRetailProcess();
       if(version==1){
    	   if(prodId==pricingTO.getId()){
    	   response=retailProcessor.processPricingUpdate(prodId,pricingTO);
    	   }
    	   else{
    		   response=ApplicationConstants.MISS_MATCH_ERROR;
    	   }
    	   
       }
       else{
    	   LOGGER.error("INVALID VERSION: "+version);
       }
       LOGGER.debug("Exiting into updatePricingDetails()<<--");
        return response;	
    } 
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/setdata")
    public String setDataInDB(PricingInsertTO pricingTO) throws UnknownHostException{
    	MyRetailProcess retailProcessor=new MyRetailProcess();
    	String response="";
    	response=retailProcessor.setTestData(pricingTO);
    	return response;
    	
    }
}
