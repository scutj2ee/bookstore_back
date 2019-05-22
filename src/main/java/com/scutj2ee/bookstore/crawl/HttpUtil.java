package com.scutj2ee.bookstore.crawl;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.client.HttpClient;

import java.io.IOException;

public class HttpUtil {

    public static HttpResponse getHtml(HttpClient httpclient, String url) throws IOException
    {
        //get方法
        HttpGet getMethod = new HttpGet(url);
        //response初始化
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK,"ok");
        //执行get方法
        response = httpclient.execute(getMethod);
        return response;
    }
}
