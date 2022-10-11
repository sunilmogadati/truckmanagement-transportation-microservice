package com.transportation.microservice;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import  okhttp3.MediaType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;



@SpringBootApplication()
public class Runner  implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//  getRouteDistance();
//
//    }

//    public static void  getRouteDistance() throws IOException {
//        RestTemplate restTemplate = new RestTemplate();
//        String fooResourceUrl
//                = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Washington%2C%20DC&destinations=New%20York%20City%2C%20NY&units=imperial";
//
//
////        String fooResourceUrl = "http://www.distance24.org/route.json?stops=Hamburg|Berlin";
//        ResponseEntity<String> response
//                = restTemplate.getForEntity(fooResourceUrl, String.class);
//        System.out.println(response.getBody());

///*
//
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("text/plain");
//        RequestBody body = RequestBody.create(mediaType, "");
//        Request request = new Request.Builder()
//                .url("")
//                .method("GET", body)
//                .build();
//        Response response = client.newCall(request).execute();
//*/

    }
}
