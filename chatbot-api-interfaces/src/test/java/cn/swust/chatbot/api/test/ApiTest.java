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

        HttpGet get = new HttpGet("https://www.zhihu.com/api/v4/comment_v5/articles/618752050/root_comment?order_by=score&limit=20&offset=");

        get.addHeader("cookie", "_xsrf=Lz4QlUs4mBUsHL519q0e7eas4Ib5r5C8; _zap=ee480b5e-b8fa-434c-928c-fc6a929a4fdd; d_c0=AcDX6PJCghaPTlK2jT2bqZEKBauLWMj7b2g=|1679478824; Hm_lvt_98beee57fd2ef70ccdd5ca52b9740c49=1679478825,1679578458,1680070499,1680248870; YD00517437729195:WM_TID=N1DKSY62eoRBFRUREFeEKl84nRtM5LRA; __snaker__id=9dY5OTYMRnWlaKGK; gdxidpyhxdE=q2pm/mLn0C3w\\WV46/E0V4t2+2KPkxokLkpTt19I58UPXmfj7BTwKmglCnhIdaNwpKW70ajSvDmKb3XWNu2rNSAsXNVnn9fTCdlYfrKE5TZ21XgfynhPJNb6137oXkz3PErw8zLsxgkjM64z6yMxu7VwUG26H5YHjAiA2RXXxQWA60ot:1680343639417; YD00517437729195:WM_NI=SbDvHE6+dyX9wWFJzZFXgySuanDPsd4L5QnaOTtF0F9AEXi/Eil1xNA6h/97G8n1NtggbzBCWHCBgiwp4Cg24zeY15a7kbt/nxWfIzwzzkg06D8gEI4XtA/wdDdItWJNb2Y=; YD00517437729195:WM_NIKE=9ca17ae2e6ffcda170e2e6eebad639b297be83b344afe78bb6d55a869e8bb1d56ab5aba8a9bc80fcebe195ce2af0fea7c3b92a91be8c97cb4ff6f5ac9adb33b5898aabf9528688a99ad27fa3b28cb1f270f894fbb2ed6b8d8cbca7b34efb9f8bb9ec2587b7a4d2fb4683eaa8d0bc3d85e8a2d2cd80a5b9ae9bc14995988da3e663b5b0fca4e63af8a6abbab43fa3e9a583f725aea89987cc72b5a6b68ce63cf69cf888c843f888bca2ae7da89cacaaf75d8a92aed3dc37e2a3; captcha_session_v2=2|1:0|10:1680342988|18:captcha_session_v2|88:OGxRWmNVZFk0MElkcmdWbVdtSzlOUGFwQk05VTMvOGhPSmQrR2paWXl3RXUwYi9CUmRVT2pBZldQUWU4eUdhaw==|3e92af061c34afb70b344a395891cea8ad11224f597ee5788adfc9cca5ac17f0; SESSIONID=jecqV39PKRbxRKHq9wMPcwiq61CwDMV9lzv5udbUFoY; JOID=VFkdBEgwm6ttAKwDczB5M_B-EYxrXffHGFOYMyx-zsAaVuJMC_NihwgCogV41ey0ia_T2z6ItndMzh1-7KxLZdU=; osd=VloUCk0ymKJjBa4Aej58MfN3H4lpXv7JHVGbOiJ7zMMTWOdOCPpsggoBqwt91--9h6rR2DeGs3VPxxN77q9Ca9A=; captcha_ticket_v2=2|1:0|10:1680343008|17:captcha_ticket_v2|704:eyJ2YWxpZGF0ZSI6IkNOMzFfUXhGSWVEeDVNRGNXTDYxbVRSSXkucGN6SGNYdkVWdk82ZGNFVi4wX28uaUVkaGcwbFZwTS1VXzR3YTdpZlJuRWpUZEhhUDUuamNjbVNLekZEVWhaRDJzTUYwVHZBVWF4bG1jamdHWGVrLTFzVEktcE41ejdQTTQ0dzcxRXZxaG1KOGZYcFdzbFNMYTJKTV9FSDlqYzFIZFNQNWZwQXFPUW5tUGRyMG1MaHFjUENfZDdUSXRGVURQT1NDMUFhTHhmbmZrT2xNZE44TTg0OWZrLTJmdUROckx2SzhETC5nZ1I5LWI3Q1NQaEkwUkRIQ2N0SVFhOG1JYWE3UC5hTnJmZG5HbEhpVDRiSUFXbDVRVzBJaVlCOU8tYWFJWmF2UC5LLTZnZ1d1SmJBUE92N2FQNFJSclVuTS03VmFUeV9zRmp6cmhac0J3OWlZUl9EcldSWThmVGltWkh0RTA1NTV0YnRTVzYxMk9WRnlkTXZHWEYuZVc1ZEJUbFVnVGIwTnBGcy1ZWEsxSFlXYlp6NWc4N1U2ZWIySldrSFJWWl9rSXUyWFM0RUY4VEtvQnk0NENqeFltbWliUkVjQVRHSF9xQS15aUNtSXhQRkhNR3p6d0hlb2JIVWc1Lm15SzRPeHIxNHQ2SERjc3I0ck8yT2VZbjU0R1FMX28uWW1tMyJ9|6b8587acad370e6480719ea494b4a369d54bf584dafa9d58be3265c5e39a9ef6; q_c1=f8469e806d6f43299b328b3b2af1ff65|1680343026000|1680343026000; tst=r; z_c0=2|1:0|10:1680343506|4:z_c0|92:Mi4xTlRFWURBQUFBQUFCd05mbzhrS0NGaVlBQUFCZ0FsVk44azBWWlFCdmpCM2R2dGdwQXlhdjRqdUVNT2tfdnZJYy1R|15283d58453e0707d0fc13af50573f20659b1356019516a4f0096c3846fcca28; Hm_lpvt_98beee57fd2ef70ccdd5ca52b9740c49=1680343870; KLBRSID=cdfcc1d45d024a211bb7144f66bda2cf|1680343872|1680342736");
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
