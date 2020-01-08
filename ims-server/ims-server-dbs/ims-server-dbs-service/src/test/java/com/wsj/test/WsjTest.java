package com.wsj.test;

import com.yianju.ims.util.HttpUtils;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WsjTest {

    @Test
    public void testGetToken() throws IOException {
        String authHost = "http://t.50-jia.com/api-user/oauth/token";

        URL url = new URL(authHost);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // 设置请求方式
        connection.setRequestMethod("POST");
        // 设置是否向HttpURLConnection输出
        connection.setDoOutput(true);
        // 设置是否从httpUrlConnection读入
        connection.setDoInput(true);
        // 设置是否使用缓存
        connection.setUseCaches(false);

        //connection.getRequestProperty("authorization","head：authorization：Authorization: Basic eWFqOnlhanNlY3JldA==");
        //设置参数类型是json格式
        connection.setRequestProperty("Authorization","Basic eWFqOnlhanNlY3JldA==");
        connection.connect();

        // String body = "{account:"+account+",startTime:"+password+"}";

        String param ="client_id=yaj&client_secret=yajsecret&grant_type=client_credentials";

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
        writer.write(param);
        writer.close();

        int responseCode = connection.getResponseCode();
        String result = "";
        if(responseCode == HttpURLConnection.HTTP_OK) {
            //定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }

            System.out.println(result);
        }

    }


    @Test
    public void testProduct() throws IOException {

        String authHost = "http://t.50-jia.com/product/yaj/findUnSynchronizedProduct";
        String param ="access_token=9fe4084a-a802-4c52-9446-0497f3c96b33";
        String post = HttpUtils.post(authHost, param, "application/x-www-form-urlencoded");
        System.out.println(post);
    }


    @Test
    public void testUpdateProduect() throws IOException {

        String authHost = "http://t.50-jia.com/product/yaj/updateSynchronizedStatus";
        String param ="access_token=9fe4084a-a802-4c52-9446-0497f3c96b33&productIds=297e78e159aa2e8e0159aa2f33bb01a2";

        String post = HttpUtils.post(authHost, param, "application/x-www-form-urlencoded");
        System.out.println(post);

    }



}
