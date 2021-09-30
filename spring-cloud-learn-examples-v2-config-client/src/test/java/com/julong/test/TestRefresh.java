package com.julong.test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * 测试类
 * @author julong
 * @date 2021/9/28 22:13
 * @desc
 */
public class TestRefresh {

    public static void main(String[] args) {
        try {
            CloseableHttpClient client= HttpClients.createDefault();
            HttpPost post = new HttpPost("http://192.168.10.27:18086/actuator/refresh");
            CloseableHttpResponse response = client.execute(post);
            System.out.println(response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
