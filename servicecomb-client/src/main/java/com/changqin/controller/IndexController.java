package com.changqin.controller;

//import com.changqin.rpc.BusinessService;
import com.changqin.rpc.BusinessService;
import com.changqin.rpc.RpcService;
import org.apache.servicecomb.provider.pojo.RpcReference;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

@Controller
@RequestMapping("/index")
public class IndexController {


    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient client;

    @RpcReference(microserviceName = "discoveryServer" ,schemaId = "businessService")
    private BusinessService businessService;

    private final RestTemplate restTemplate = new RestTemplate();

    public void getsRemoteServiceFromDiscoveryClient() throws Exception {
        URI remoteUri = discoveryClient.getInstances("discoveryServer").get(0).getUri();

        assertThat(remoteUri).isNotNull();

        String response = restTemplate.getForObject(
                remoteUri.toString() + "/greeting/sayhello/{name}",
                String.class,
                "Mike");

        assertThat(response).isEqualTo("hello Mike");
    }

    @RequestMapping("")
    @ResponseBody
    public String String() throws Exception {
        getsRemoteServiceFromDiscoveryClient();
        return "222";
    }

    @RequestMapping("/home")
    @ResponseBody
    public String home(){
        return "111";
    }

    @RequestMapping(value = "/rpc",method = RequestMethod.GET)
    @ResponseBody
    public String rpc(){
        return businessService.say("i am client");
    }

    @RequestMapping("/gateway")
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

            assertThat(response).isEqualTo("hello Mike");
        }
    }
}
