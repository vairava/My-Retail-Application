package com.work.myretail.util;

import java.lang.reflect.Type;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MarshallingUtil {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

     /**
     * Unmarshals the JSON representation of an Object into an instance of the
     * Object
     * @param <T>
     *
     * @param toClass
     *            Target class of the unmarshalling
     * @param inputString
     *            JSON representation of the Object
     *
     * @return Object represented by the JSON string
     */
    public static <T> Object unmarshalFromJSON(String inputString, Class<T> typeOfT) {
    	Object data = null;
    	if(!StringUtils.isEmpty(inputString)){
    	
    		data = gson.fromJson(inputString, typeOfT);
    	}
        return data;
    }

    /**
     * marshals the Object to a JSON representation of the Object
     * 
     * @param data
     * @return
     */
	public static String marshaltoJSON(Object data) {
		String value = null;
		if (data != null) {

			value = gson.toJson(data);

		}
		return value;
	}
    
    
    private MarshallingUtil() {
    }

	public static <T> Object unmarshalFromJSON(String inputString,
			Type listType) {

		Object data = null;
    	if(!StringUtils.isEmpty(inputString)){
    	
    		data = gson.fromJson(inputString, listType);
    	}
        return data;
	}
}
