package com.work.myretail.helper;

	import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

public class HTTPClientHelper {

	private static final Logger logger = Logger
			.getLogger(HTTPClientHelper.class);

	private final String USER_AGENT = "Mozilla/5.0";

	public String sendGet(String url) throws Exception {

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		request.addHeader("User-Agent", USER_AGENT);

		HttpResponse response = client.execute(request);

		logger.debug("\nSending 'GET' request to URL : " + url);
		logger.debug("Response Code : "
				+ response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		logger.debug(result.toString());
		return result.toString();
	}


}
