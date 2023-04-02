package cn.swust.chatbot.api.test;

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
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiTest {
    @Test
    public void  query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.bilibili.com/x/v2/reply/main?jsonp=jsonp&next=0&type=12&oid=22788449&mode=2&plat=1");
        get.addHeader("cookie", "buvid3=9B8A984E-4D6C-BBEA-0E54-1B1B001F949E95713infoc; b_nut=1679364295; i-wanna-go-back=-1; _uuid=8441EF3A-412A-410AA-DFF9-D481E91D3101A96696infoc; home_feed_column=4; DedeUserID=66705325; DedeUserID__ckMd5=66da250c899e904e; CURRENT_FNVAL=4048; rpdid=0zbfvUxDUI|EuTDt531|2ZG|3w1PErnM; PVID=1; nostalgia_conf=-1; CURRENT_QUALITY=64; b_ut=5; header_theme_version=CLOSE; CURRENT_PID=0c673870-cee4-11ed-a499-093ff39cb05b; buvid4=CFFCC5FB-107D-F71D-9F71-D05F69E8D35697288-023032110-Aewihy+MgAaSKuckaztooBnfn7Nwj5RQ1+OWyeSRJGMIOMRpwBh26Q==; fingerprint=7f39d920bad8ee4bb83b21742f772704; buvid_fp_plain=undefined; SESSDATA=a1435c41,1695900629,ff26d*41; bili_jct=9c4389c3135efcdf6a0c32dd5f5bfa64; sid=6lvvq2jr; bsource=search_baidu; b_lsid=7AF85DCB_1873D3AB640; bp_video_offset_66705325=779638243485286500; buvid_fp=7f39d920bad8ee4bb83b21742f772704");
        get.addHeader("Content-Type","application/json;charset=utf8");
        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException{
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.bilibili.com/x/v2/reply/add");
        post.addHeader("cookie", "buvid3=9B8A984E-4D6C-BBEA-0E54-1B1B001F949E95713infoc; b_nut=1679364295; i-wanna-go-back=-1; _uuid=8441EF3A-412A-410AA-DFF9-D481E91D3101A96696infoc; home_feed_column=4; DedeUserID=66705325; DedeUserID__ckMd5=66da250c899e904e; CURRENT_FNVAL=4048; rpdid=0zbfvUxDUI|EuTDt531|2ZG|3w1PErnM; PVID=1; nostalgia_conf=-1; CURRENT_QUALITY=64; b_ut=5; header_theme_version=CLOSE; CURRENT_PID=0c673870-cee4-11ed-a499-093ff39cb05b; buvid4=CFFCC5FB-107D-F71D-9F71-D05F69E8D35697288-023032110-Aewihy+MgAaSKuckaztooBnfn7Nwj5RQ1+OWyeSRJGMIOMRpwBh26Q==; fingerprint=7f39d920bad8ee4bb83b21742f772704; buvid_fp_plain=undefined; buvid_fp=7f39d920bad8ee4bb83b21742f772704; bp_video_offset_66705325=779555866010452100; b_lsid=CC95C38C_1873C7E08ED; SESSDATA=a1435c41,1695900629,ff26d*41; bili_jct=9c4389c3135efcdf6a0c32dd5f5bfa64; sid=6lvvq2jr; bsource=search_baidu");
        /*String paramJson = "{" +
                "oid:22788449," +
                "type:12," +
                "message:我不会," +
                "plat:1," +
                "ordering:heat," +
                "jsonp:jsonp," +
                "csrf:9c4389c3135efcdf6a0c32dd5f5bfa64" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json","UTF-8"));
        post.setEntity(stringEntity);*/
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("oid","22788449"));
        params.add(new BasicNameValuePair("type","12"));
        params.add(new BasicNameValuePair("message","我不会"));
        params.add(new BasicNameValuePair("plat","1"));
        params.add(new BasicNameValuePair("ordering","heat"));
        params.add(new BasicNameValuePair("jsonp","jsonp"));
        params.add(new BasicNameValuePair("csrf","9c4389c3135efcdf6a0c32dd5f5bfa64"));
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
        post.setEntity(urlEncodedFormEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
