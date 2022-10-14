package com.transportation.microservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication()
@EnableSwagger2
//@EnableEurekaClient
public class Runner  implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        parseJson( calculate("8333 abbott ave N Brooklyn Park, MN 55443", "2450 Winnetka ave N, Minneapolis, MN, 55427"));

    }

}
