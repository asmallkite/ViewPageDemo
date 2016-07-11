package com.example.a10648.viewpagedemo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 李争 on 2016/7/10 0010.
 * 简化网络操作，对通用操作进行封装
 */
public class HttpUtil {
    public static String sendHttpRequest(String address) {
        HttpURLConnection connection = null; //HttpURLConnection是抽象类，无法直接实例化，需要调用URL的openConnectin
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(8000); //连接超时
            connection.setReadTimeout(8000); //读取超时
            connection.setDoInput(true); //设置是否URLConnection读入   whether URLConnection allows input
            connection.setDoOutput(true); //设置是否URLConnection输出  whether URLConnection allows output
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return  response.toString();
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        } finally {
            if (connection != null){
                connection.disconnect();
            }
        }
    }
}
