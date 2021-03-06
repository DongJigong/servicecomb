package com.changqin;

import org.apache.servicecomb.springboot2.starter.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableServiceComb
public class ServiceCombClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCombClientApplication.class,args);
    }
}
