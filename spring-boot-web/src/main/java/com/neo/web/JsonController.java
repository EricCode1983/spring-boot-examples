package com.neo.web;

import com.neo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//call url and do the json convert
//https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
@RestController
public class JsonController {


    /**
     * HttpURLConnection
     * **/
    @RequestMapping("/getTitles")
    public String getMoviesTitles(String title) throws IOException {

        URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + title);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder response=new StringBuilder();
        String line;

        while((line=br.readLine())!=null){
            response.append(line);
        }

        System.out.println(response);

        return response.toString();
    }
}
