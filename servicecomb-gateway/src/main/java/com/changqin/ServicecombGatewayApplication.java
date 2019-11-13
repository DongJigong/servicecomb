package com.changqin;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableServiceComb
@EnableZuulProxy
@EnableDiscoveryClient
public class ServicecombGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicecombGatewayApplication.class,args);
    }
}
