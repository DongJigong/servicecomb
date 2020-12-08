package com.changqin.controller;

//import com.changqin.rpc.BusinessService;

import com.changqin.rpc.BusinessService;
import org.apache.servicecomb.provider.pojo.RpcReference;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@RestSchema(schemaId = "client")
@RequestMapping("/index")
public class IndexController {


    @RpcReference(microserviceName = "discoveryServer" ,schemaId = "businessService")
    private BusinessService businessService;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("")
    @ResponseBody
    public String String() throws Exception {
//        getsRemoteServiceFromDiscoveryClient();
        return "222";
    }

    @GetMapping("/home")
    @ResponseBody
    public String home(){
        return "111";
    }

    @RequestMapping(value = "/rpc",method = RequestMethod.GET)
    @ResponseBody
    public String rpc(){
        return businessService.say("i am client");
    }

    @GetMapping("/gateway")
    @ResponseBody
    public String gateway(){
        getsRemoteServiceThroughGateway();
        return "333";
    }

    public void getsRemoteServiceThroughGateway() {
        //loop three time to insure only rest endpoint get
        for (int i = 0; i < 3; i++) {
            String response = restTemplate.getForObject(
                    "http://localhost:8099/gateway/greeting/sayhello/{name}",
                    String.class,
                    "Mike");

//            assertThat(response).isEqualTo("hello Mike");
        }
    }
}
