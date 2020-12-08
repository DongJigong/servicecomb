package com.changqin.controller;

//import com.changqin.rpc.BusinessService;

import com.changqin.rpc.BusinessService;
import org.apache.servicecomb.provider.pojo.RpcReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/index")
public class IndexController {



    @RpcReference(microserviceName = "discoveryServer" ,schemaId = "businessService")
    private BusinessService businessService;

    private final RestTemplate restTemplate = new RestTemplate();


    @RequestMapping("")
    @ResponseBody
    public String String() throws Exception {
//        getsRemoteServiceFromDiscoveryClient();
        return "222";
    }

    @RequestMapping("/page")
    public String page() throws Exception {

        return "index";
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

//            assertThat(response).isEqualTo("hello Mike");
        }
    }
}
