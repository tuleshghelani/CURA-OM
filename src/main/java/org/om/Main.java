package org.om;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.json.simple.JSONObject;
import org.om.Model.Temp1;
import org.om.Service.Table1DataSave;
import org.om.repository.Table2SaveData;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException {

        String token="" ;
//                token =getToken();
//        getCURAData(token);
        Table2SaveData table2SaveData= new Table2SaveData();
        table2SaveData.saveData(token);
        System.out.println("hii");

    }

    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }


    public static String getCURAData(String token) {
        System.out.println("Inside getcuraData()");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String file = "JSON/CURA.json";
        try {
            String json = readFileAsString(file);
            System.out.println(json);
            JsonNode node = mapper.readTree(json);
//            List<T> ts = mapper.readValue(node, new TypeReference<List<T>>(){});
//            List<Temp1> stockList = mapper.convertValue(node.get("Body").get("IXRes").get("Data").get(0).toString(), new TypeReference<List<Temp1>>() {});
//            List<Temp1>  temp1 = mapper.readValue(node.get("Body").get("IXRes").get("Data").get(0).toString(),List.class);
            Temp1[]  temp1 = mapper.readValue(node.get("Body").get("IXRes").get("Data").get(0).toString(),Temp1[].class);
            System.out.println("Temp1 : "+ temp1);
//            System.out.println("stockList : "+stockList.toString());

            JsonNode node1 = mapper.readTree(node.get("Body").get("IXRes").get("Data").get(0).toString());
            List<Temp1>  temp2 = mapper.readValue(node.get("Body").get("IXRes").get("Data").get(0).toString(),List.class);

//            System.out.println("temp2 : "+temp2.get(0).getQueryName());
            System.out.println("Node : "+node.get("Body").get("IXRes").get("Data").get(0));
            Table1DataSave table1DataSave= new Table1DataSave();
            table1DataSave.dataStore(Arrays.asList(temp1));
            /*JsonNode node = mapper.readTree(content);
            System.out.println("Node : "+node);*/
            /*List<Temp1> users = mapper.readValue(inputStream,typeReference);
            System.out.printf("Users : "+users);
//            userService.save(users);
            System.out.println("Users Saved!");*/
        } catch (Exception e){
            System.out.println("Unable to save users: " + e.getMessage());
        }
        /*ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        try {

            System.out.println("Completed SSL");
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .connectTimeout(1000, TimeUnit.SECONDS)
                    .writeTimeout(1000, TimeUnit.SECONDS)
                    .readTimeout(3000, TimeUnit.SECONDS)
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            String content = String.format("{\"Header\": {\"ChannelID\": \"OM_Test\",\"TokenID\": %s,\"RefID\": \"IXData\"},\"Body\": {\"IXReq\": {\"OpCode\": \"101\",\"Data\": {\"RegID\":\"5082\"}}}}", token);

            RequestBody body = RequestBody.create(mediaType, content);
            System.out.println("Body : "+ content);
            Request request = new Request.Builder()
                    .url("https://omtest.curasoftware.com/cura/nodeAPI/ix/post")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            String JSONResponse = response.body().string();
            System.out.println(" JSONResponse : " + JSONResponse);
            JsonNode node = mapper.readTree(JSONResponse);
            System.out.println("Node : "+node);

            return token;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }*/


        return null;
    }
    public static String getToken() {


        System.out.println("Inside getToken()");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        try {
//
//            HttpsURLConnection conn = null;
//            URL url = new URL("{\n" +
//                    "    \"AuthReq\": {\n" +
//                    "      \"ChannelID\": \"OM_Test\",\n" +
//                    "      \"AuthUID\": \"PKhunt@oldmutual.com\",\n" +
//                    "      \"AuthPass\": \"Apple#12345\"\n" +
//                    "    }\n" +
//                    "  }");
//            conn = (HttpsURLConnection) url.openConnection();
//            SSLContext sc = SSLContext.getInstance("SSL");

//            System.out.println("Completed SSL");
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n" +
                    "  \"Header\": {\n" +
                    "    \"MsgType\": \"AuthReq\",\n" +
                    "    \"RefID\": \"12345ABC\"\n" +
                    "  },\n" +
                    "  \"Body\": {\n" +
                    "    \"AuthReq\": {\n" +
                    "      \"ChannelID\": \"OM_Test\",\n" +
                    "      \"AuthUID\": \"PKhunt@oldmutual.com\",\n" +
                    "      \"AuthPass\": \"Apple#12345\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}");
            Request request = new Request.Builder()
                    .url("https://omtest.curasoftware.com/cura/nodeAPI/auth/")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            String JSONResponse = response.body().string();
//            System.out.println(" JSONResponse : " + JSONResponse);
            JsonNode node = mapper.readTree(JSONResponse);
            String token = String.valueOf(node.get("Body").get("AuthRes").get("TokenID"));
//            System.out.println("node : "+node.get("Body").get("AuthRes").get("TokenID"));

//            System.out.println("response : "+response.body().string());

//            System.out.println("JSONResponse"+JSONResponse);


//            Login login = mapper.readValue(JSONResponse, Login.class);
//            System.out.println("Login " + login.getToken());
            return token;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
