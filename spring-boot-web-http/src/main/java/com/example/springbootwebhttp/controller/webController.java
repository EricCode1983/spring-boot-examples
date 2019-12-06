package com.example.springbootwebhttp.controller;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.json.simple.*;
import org.json.simple.parser.*;

@RestController
public class webController {


    /*HttpClient*/
    private final CloseableHttpClient httpClient= HttpClients.createDefault();
    /*OKHttp*/
    private final OkHttpClient okHttpClient = new OkHttpClient();

    private String basicUrl="https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman";

    @RequestMapping("/getTitlesByHttpUrl")
    public String httpUrlGet()
    {

        String title="";
        StringBuilder response=new StringBuilder();
        List<String> result = new ArrayList<String>();

        try {
            URL url=new URL(basicUrl+title);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line=br.readLine())!=null){
                response.append(line);
            }
            int totalPage=0;
            totalPage=GetTotalPage(response.toString());

            for (int i = 0; i < totalPage; i++) {
                URL nextURL = new URL(basicUrl + "&page=" + i);
                HttpURLConnection nextConnection=(HttpURLConnection)nextURL.openConnection();
                nextConnection.setRequestMethod("GET");
                BufferedReader input = new BufferedReader(new InputStreamReader(nextConnection.getInputStream()));
                while ((line = input.readLine()) != null) {
                    result.addAll(getTitlesArray(line));
                }

            }


           // System.out.println(response.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       finally {
            StringBuilder resultSb=new StringBuilder();
            for (String temp : result) {
                System.out.println(temp);
                resultSb.append(temp);
            }
            return resultSb.toString();
        }
    }

    private static List<String> getTitlesArray(String line){

        List<String> result = new ArrayList<String>();
        JSONParser parser=new JSONParser();
        try {
            JSONObject jsonObject=(JSONObject)parser.parse(line);
            JSONArray data = (JSONArray) jsonObject.get("data");
            Iterator<JSONObject> itr = data.iterator();
            while (itr.hasNext()){
                Object item = new JSONParser().parse(itr.next().toString());
                JSONObject itemObj = (JSONObject) item;
                String theTitle = (String) itemObj.get("Title");
                result.add(theTitle);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        finally {
            Collections.sort(result);
            return result;
        }

    }

    /* JSON CONVERT WITH ORG.JSON.SIMPLE */
    private int GetTotalPage(String response)
    {
        int totalPage=0;
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(response);
             totalPage= Integer.valueOf(String.valueOf(jsonObject.get("total_pages")));
        } catch (ParseException e) {
            e.printStackTrace();
            return totalPage;
        }
        finally {
            return totalPage;
        }

    }




    @RequestMapping("/getTitlesByApacheHttpClient")
    public String httpClientGet(){

        String result= sendGetHttpClient();
        return result;
    }

    private String sendGetHttpClient(){
        HttpGet request=new HttpGet(basicUrl);
        //request.addHeader();
        String result="";
        try {
            CloseableHttpResponse response=httpClient.execute(request);
            System.out.println(response.getStatusLine().toString());

            HttpEntity httpEntity=response.getEntity();
            Header headers=httpEntity.getContentType();

            if(httpEntity!=null){

                 result= EntityUtils.toString(httpEntity);
                System.out.println(result);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return result;
        }
    }


    @RequestMapping("/getTitlesByOkHttp")
    public String okHttpGet(){

        String result= sendOkHttpGet();
        return result;
    }

    private String sendOkHttpGet(){

        Request request=new Request.Builder()
                .url(basicUrl)
                .build();

        String result="";
        try {
            Response response=okHttpClient.newCall(request).execute();

            if(!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            result= response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            return result;
        }

    }
}
