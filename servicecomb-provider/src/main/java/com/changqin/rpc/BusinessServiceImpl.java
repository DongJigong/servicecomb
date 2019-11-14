package com.changqin.rpc;

import io.swagger.annotations.SwaggerDefinition;
import org.apache.servicecomb.provider.pojo.RpcSchema;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RpcSchema(schemaId = "businessService")
@SwaggerDefinition
public class BusinessServiceImpl implements BusinessService {

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String say(@RequestParam(name="name") String name) {
        return "hello "+name;
    }
}
