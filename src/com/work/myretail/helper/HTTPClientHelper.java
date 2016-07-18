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

	// HTTP POST request
	public String sendPost() throws Exception {

		String url = "http://IBDFQAB3.SYSPLEX.HOMEDEPOT.COM:20545/CICS/po00/popd10i";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

		post.setHeader("User-Agent", USER_AGENT);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		/*
		 * urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
		 * urlParameters.add(new BasicNameValuePair("cn", ""));
		 * urlParameters.add(new BasicNameValuePair("locale", ""));
		 * urlParameters.add(new BasicNameValuePair("caller", ""));
		 * urlParameters.add(new BasicNameValuePair("num", "12345"));
		 */
		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(post);
		logger.debug("\nSending 'POST' request to URL : " + url);
		logger.debug("Post parameters : " + post.getEntity());
		logger.debug("Response Code : "
				+ response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		StringBuffer responseXML = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			responseXML.append(line);
		}

		logger.debug(responseXML.toString());
		return responseXML.toString();
	}

}
