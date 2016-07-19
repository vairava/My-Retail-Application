package com.work.myretail.util;

public final class ApplicationConstants {

	public static String PRODUCT_ID="id";
	public static String PRODUCT_NAME="productname";
	public static String VALUE="value";
	public static String CURRENCY_CODE="currency_code";
	public static String INSERT_SUCCESS="Pricing data inserted successfully";
	public static String UPDATE_SUCCESS="Pricing data updated successfully";
	public static String PRODUCT_ID_MISS_ERROR="Product id is not found in our database.";
	public static String URL_FIRST_PART="https://api.target.com/products/v3/";
	public static String URL_SECOND_PART="?fields=descriptions&id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz";
	public static String PRODUCT_ID_EXIST="Product Id already exist in db.";
	public static String MONGO_DB_NAME="myRetailDB";
	public static String MONGO_TABLE_NAME="pricingData";
	public static String LOCAL_HOST="localhost";
	public static String MISS_MATCH_ERROR="Product Id on URL and JSON doesnt match.";
}
