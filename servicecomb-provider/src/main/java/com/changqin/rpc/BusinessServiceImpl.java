package com.changqin.rpc;

import io.swagger.annotations.SwaggerDefinition;
import org.apache.servicecomb.provider.pojo.RpcSchema;
import org.springframework.stereotype.Component;

@Component
@RpcSchema(schemaId = "businessService")
@SwaggerDefinition(basePath = "/provider/rest")
public class BusinessServiceImpl implements BusinessService {

    public String say(String name) {
        return "hello "+name;
    }
}
