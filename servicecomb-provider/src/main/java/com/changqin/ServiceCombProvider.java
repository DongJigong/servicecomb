package com.changqin;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
//@EnableServiceComb
@EnableFeignClients
public class ServiceCombProvider {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCombProvider.class,args);
    }
}
