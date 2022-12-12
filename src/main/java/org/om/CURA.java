package org.om;

//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//import com.amazonaws.services.lambda.runtime.events.S3Event;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpRequest;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.model.S3Event;
import okhttp3.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class CURA implements RequestHandler<S3Event, String> {

   /* @Override
    public String handleRequest(S3Event input, Context context) {


        try{
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost("http://10.128.244.21/api/login/generate-token");

// Request parameters and other properties.
            List<NameValuePair> params = new ArrayList<>(2);
            params.add(new BasicNameValuePair("username", "pkhunt"));
            params.add(new BasicNameValuePair("password", "admin"));
            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

//Execute and get the response.
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                try (InputStream instream = entity.getContent()) {
                    // do something useful
                }
            }


        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }*/

    @Override
    public String handleRequest(S3Event input, Context context) {
        System.out.println("hii");

        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n    \"username\": \"pkhunt\",\r\n    \"password\": \"admin\"\r\n}");
            Request request = new Request.Builder()
                    .url("http://10.128.244.21/api/login/generate-token")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            String JSONResponse = response.body().toString();
            System.out.println(" JSONResponse : " + JSONResponse);
            System.out.println("response : " + response.body().string());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
