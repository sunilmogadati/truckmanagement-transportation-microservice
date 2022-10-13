package com.transportation.microservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
@SpringBootApplication()
@EnableSwagger2
public class Runner  implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//  getRouteDistance();

    }

    public static void  getRouteDistance() throws IOException {
//        RestTemplate restTemplate = new RestTemplate();
//        String fooResourceUrl
//                = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Washington%2C%20DC&destinations=New%20York%20City%2C%20NY&units=imperial&key=AIzaSyDyih2FdRgDeifQ3VsRPq4ISfFPqaaJ8VQ";
//
//
////        String fooResourceUrl = "http://www.distance24.org/route.json?stops=Hamburg|Berlin";
//        ResponseEntity<String> response
//                = restTemplate.getForEntity(fooResourceUrl, String.class);
//        System.out.println(response.getBody());
//
///*

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
