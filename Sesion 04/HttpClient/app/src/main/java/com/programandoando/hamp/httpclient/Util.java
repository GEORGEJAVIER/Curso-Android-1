package com.programandoando.hamp.httpclient;

/**
 * Created by HAMP on 6/06/2016.
 */
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Util {
    public static final String URL_APP =
            "http://127.0.0.1:8086/ApiServices/service/";
    //http://www.programandoando.com/ApiServices/service
    //192.168.1.36
    //http://www.journaldev.com/2552/spring-rest-example-tutorial-spring-restful-web-services
    //http://javarticles.com/2016/05/spring-boot-rest-example.html
    //http://laurel.datsi.fi.upm.es/docencia/asignaturas/daw
    //https://www.youtube.com/channel/UCv9cJh8ivmg6JJMQiQ22RWA
    //https://www.youtube.com/watch?v=WiKubjbKA00
    //https://www.youtube.com/watch?v=cRd3kPIROmo

    private Util()
    {
    }
    public static String execJsonGetRequest(String url) throws ClientProtocolException, IOException
    {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://192.168.1.36:8086/ApiServices/service/"+url);
        httpGet.setHeader("content-type","application/json");
        HttpResponse response = httpclient.execute(httpGet);
        String jsonResult = EntityUtils.toString(response.getEntity());
        return jsonResult;
    }

}
