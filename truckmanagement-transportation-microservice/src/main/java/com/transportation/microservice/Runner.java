package com.transportation.microservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
////import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.io.IOException;
@SpringBootApplication()
@EnableSwagger2
//@EnableEurekaClient
public class Runner{
    public static void main(String[] args) { SpringApplication.run(Runner.class, args); }
    
}
