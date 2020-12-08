package com.changqin;

import org.apache.servicecomb.springboot2.starter.EnableServiceComb;
import org.apache.servicecomb.tracing.zipkin.EnableZipkinTracing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableServiceComb
@EnableZipkinTracing
public class ServiceCombProvider {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCombProvider.class,args);
    }
}
