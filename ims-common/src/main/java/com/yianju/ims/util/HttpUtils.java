package com.yianju.ims.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 工具类
 */
public class HttpUtils {




    private static final long serialVersionUID = -1997745012463845780L;

    /**
     * POST方式请求数据
     * @param httpUrl 请求的路径
     * @param content 请求参数
     * @param isParamBase64 请求参数是否BASE64编码
     * @return
     * @throws IOException
     */
    public static String postRequest(String httpUrl,String content,boolean isParamBase64) throws IOException{
        URL url = new URL(httpUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(5 * 1000);
        connection.setReadTimeout(5 * 1000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        // Post 请求不能使用缓存
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        if(isParamBase64){
            connection.setRequestProperty("Content-Type", "application/json");
        }
        connection.connect();

        if(content!=null){
            OutputStream out = new DataOutputStream(connection.getOutputStream());
            if(isParamBase64){
                out.write(getBASE64(content).getBytes());
            }else{
                out.write(content.getBytes());
            }
            out.flush();
            out.close();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        connection.disconnect();
        return sb.toString();
    }


    /**
     * POST方式请求数据(参数不转BASE64)
     * @param httpUrl 请求的路径
     * @param content 请求参数
     * @return
     * @throws IOException
     */
    public static String postRequest(String httpUrl,String content) throws IOException{
        return postRequest(httpUrl,content,false);
    }


    /**
     * 传递中文用 base64转化
     */
    private static String getBASE64(String s) {
        if (s == null)
            return null;
        return (new sun.misc.BASE64Encoder()).encode(s.getBytes());
    }

    /**
     * @param httpUrl
     * @param content
     * @param encode
     * @return
     * @throws IOException
     */
    public static String post(String httpUrl,String content,String encode) throws IOException {

        URL url = new URL(httpUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(5 * 1000);
        connection.setReadTimeout(5 * 1000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        // Post 请求不能使用缓存
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type", encode);
        connection.connect();

        if(content!=null){
            OutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(content.getBytes());
            out.flush();
            out.close();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        connection.disconnect();
        return sb.toString();
    }


    /**
     * 请求soup接口
     * @param httpUrl
     * @param content
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    public static String postSoup(String httpUrl,String content) throws MalformedURLException, IOException{
        return postSoup(httpUrl, content, 5 * 1000, 5 * 1000);
    }

    /**
     * 请求soup接口
     * @param httpUrl
     * @param content
     * @param reedTimeout
     * @param connectTimeout
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    public static String postSoup(String httpUrl,String content,int reedTimeout,int connectTimeout) throws MalformedURLException, IOException{

        URL url = new URL(httpUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(reedTimeout);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        // Post 请求不能使用缓存
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        connection.setRequestProperty("SOAPAction", httpUrl);
        connection.connect();

        if(content!=null){
            OutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(content.getBytes());
            out.flush();
            out.close();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        connection.disconnect();
        return sb.toString();
    }

    public static String get(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);


            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection
                        .getInputStream()));
                String temp;
                while ((temp = reader.readLine()) != null) {
                    sb.append(temp);
                }
                reader.close();
            }

            connection.disconnect();
        } catch (Exception e) {
            return e.toString();
        }

        return sb.toString();
    }

}
