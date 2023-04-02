package cn.swust.chatbot.api.domain.bilibili.service;

import cn.swust.chatbot.api.domain.bilibili.IBiliBiliApi;
import cn.swust.chatbot.api.domain.bilibili.model.aggregates.UnAnswerQuestionsAggregates;
import cn.swust.chatbot.api.domain.bilibili.model.res.AnswerRes;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BiliBiliApi implements IBiliBiliApi {
    private Logger logger = LoggerFactory.getLogger(BiliBiliApi.class);
    @Override
    public UnAnswerQuestionsAggregates queryUnAnswerQuestionsReplies(String old, String cookie) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.bilibili.com/x/v2/reply/main?jsonp=jsonp&next=0&type=12&oid="+old+"&mode=2&plat=1");
        get.addHeader("cookie", cookie);
        get.addHeader("Content-Type","application/json;charset=utf8");
        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String jsonStr = EntityUtils.toString(response.getEntity());
            logger.info("拉取问题数据：old: {} jsonStr: {}",old,jsonStr);
            return JSON.parseObject(jsonStr,UnAnswerQuestionsAggregates.class);
        }else {
            throw new RuntimeException("queryUnAnsweredQuestionsReplies Err Code is"+response.getStatusLine().getStatusCode());
        }
    }

    @Override
    public String answer(String old,String root,String parent, String cookie, String message, String csrf) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.bilibili.com/x/v2/reply/add");
        post.addHeader("cookie", cookie);
        post.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5060.66 Safari/537.36");
         /* 测试
            oid: 22788449
            type: 12
            root: 158861844976
            parent: 158861844976
            message: 怎么
            plat: 1
            ordering: time
            jsonp: jsonp
            csrf: 9c4389c3135efcdf6a0c32dd5f5bfa64
         */
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("oid",old));
        params.add(new BasicNameValuePair("type","12"));
        params.add(new BasicNameValuePair("message",message));
        params.add(new BasicNameValuePair("root",root));
        params.add(new BasicNameValuePair("parent",parent));
        params.add(new BasicNameValuePair("plat","1"));
        params.add(new BasicNameValuePair("ordering","heat"));
        params.add(new BasicNameValuePair("jsonp","jsonp"));
        params.add(new BasicNameValuePair("csrf",csrf));
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
        post.setEntity(urlEncodedFormEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String jsonStr = EntityUtils.toString(response.getEntity());
            logger.info("回答问题结果：old:{} , jsonStr:{}",old,jsonStr);
            AnswerRes answerRes = JSON.parseObject(jsonStr, AnswerRes.class);
            return answerRes.isCode();
        }else {
            throw new RuntimeException("answer Err code is" + response.getStatusLine().getStatusCode());
        }
    }
}
