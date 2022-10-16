package com.transportation.microservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.smartystreets.api.us_street.*;


@SpringBootApplication()
@EnableSwagger2
//@EnableEurekaClient
public class Runner  implements CommandLineRunner {
    @Value("${auth-id}")
    String key;
    @Value("${auth-token}")
    String hostname;




    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Lookup lookup = new Lookup();

    }

}
