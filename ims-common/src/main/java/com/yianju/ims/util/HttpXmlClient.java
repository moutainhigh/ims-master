package com.yianju.ims.util;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author shun
 * @date 2017年1月12日 上午11:19:34
 * @Discripition 
 * <p>Company: eaju</p>
 * @version 1.0
 */
public class HttpXmlClient {

	Logger log = LoggerFactory.getLogger(HttpXmlClient.class);
	
	public final static String APPLICATION_PROTOBUF = "application/x-protobuf;charset=UTF-8";
    public final static String APPLICATION_JSON="application/json;charset=UTF-8";
    public final static String APPLICATION_XML="application/xml;charset=UTF-8";
    public final static String TEXT_PLAIN="text/plain;charset=UTF-8";
	
	public static String put(String url, Map<String, String> params,String accept) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String body = null;
		HttpPut put = putForm(url, params);
		put.setHeader("Accept", accept);
		body = invoke(httpclient, put);
		httpclient.getConnectionManager().shutdown();

		return body;
	}

	public static String patch(String url, Map<String, String> params,String accept) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String body = null;

		HttpPatch patch = patchForm(url, params);
		patch.setHeader("Accept", accept);
		body = invoke(httpclient, patch);

		httpclient.getConnectionManager().shutdown();

		return body;
	}
	public static String post(String url, Map<String, String> params,String accept) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String body = null;

		HttpPost post = postForm(url, params);
		post.setHeader("Accept", accept);
		body = invoke(httpclient, post);

		httpclient.getConnectionManager().shutdown();

		return body;
	}
	public static String delete(String url,String accept) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String body = null;

		HttpDelete delete = new HttpDelete(url);
		delete.setHeader("Accept", accept);
		body = invoke(httpclient,delete);

		httpclient.getConnectionManager().shutdown();

		return body;
	}
	
	public static String post(String url, Map<String, String> params) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String body = null;

		HttpPost post = postForm(url, params);
		body = invoke(httpclient, post);

		httpclient.getConnectionManager().shutdown();

		return body;
	}

	public static String get(String url,String accept) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String body = null;

		HttpGet get = new HttpGet(url);
		get.setHeader("Accept", accept);
		body = invoke(httpclient, get);

		httpclient.getConnectionManager().shutdown();

		return body;
	}

	private static String invoke(DefaultHttpClient httpclient,
			HttpUriRequest httpost) {

		HttpResponse response = sendRequest(httpclient, httpost);
		String body = paseResponse(response);

		return body;
	}

	private static String paseResponse(HttpResponse response) {
		HttpEntity entity = response.getEntity();

		String charset = EntityUtils.getContentCharSet(entity);

		String body = null;
		try {
			body = EntityUtils.toString(entity);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return body;
	}

	private static HttpResponse sendRequest(DefaultHttpClient httpclient,
			HttpUriRequest httpost) {
		HttpResponse response = null;

		try {

			response = httpclient.execute(httpost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	private static HttpPost postForm(String url, Map<String, String> params) {

		HttpPost httpost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}

		try {
			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return httpost;
	}

	private static HttpPut putForm(String url, Map<String, String> params) {
		HttpPut httpPut = new HttpPut(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}

		try {
			httpPut.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return httpPut;
	}
	private static HttpPatch patchForm(String url, Map<String, String> params) {
		HttpPatch httpPatch = new HttpPatch(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}

		try {
			httpPatch.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return httpPatch;
	}
	
	 public static String postJson(String url,String json) throws IOException{

	        // 实例声明
	        CloseableHttpClient httpClient = null;
	        HttpPost httpPost = null;
	        StringEntity se = null;
	        HttpResponse hr = null;
	        InputStream is = null;

	        try {

	            httpClient = HttpClients.createDefault();

	            // 创建httppost
	            httpPost = new HttpPost(url);

	            //设置请求头
	            httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);

	            //设置请求参数
	            se = new StringEntity(json,"UTF-8");
	            se.setContentType("text/json");
	            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
	            httpPost.setEntity(se);

	            hr = httpClient.execute(httpPost);
	            StatusLine sl = hr.getStatusLine();
	            if(sl.getStatusCode() == 200){

	                //拿到响应头的实体
	                HttpEntity he = hr.getEntity();

	                //拿到实体中的内容，其实就是服务器返回的输入流
	                is = he.getContent();

	                return StreamUtils.getTextFromStream(is);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally { //关闭流

	            if (httpClient!=null)
	            {
	                httpClient.close();
	            }

	            if (is!=null)
	            {
	                is.close();
	            }

	            httpPost = null;
	            se = null;
	            hr = null;
	        }

	        return null;
	    }
	
}
