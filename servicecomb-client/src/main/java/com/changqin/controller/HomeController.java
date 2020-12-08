package com.changqin.controller;

import com.changqin.rpc.RpcService;
import org.apache.servicecomb.provider.pojo.RpcReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @RpcReference(microserviceName = "discoveryServer" ,schemaId = "greeting")
    private RpcService rpcService;

    @GetMapping("/test")
    public String test(){

        rpcService.sayHello("1111");
        return "2222";
    }
}
