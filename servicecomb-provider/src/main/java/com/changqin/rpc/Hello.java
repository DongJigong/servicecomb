package com.changqin.rpc;

import com.changqin.model.Person;
import io.swagger.annotations.SwaggerDefinition;
import org.apache.servicecomb.provider.pojo.RpcSchema;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;

@SwaggerDefinition
@RpcSchema(schemaId = "springmvcHello")
@RequestMapping(path = "/springmvchello", produces = MediaType.APPLICATION_JSON)
public interface Hello {

    @RequestMapping(path = "/sayhi", method = RequestMethod.POST)
    String sayHi(String name);

    @RequestMapping(path = "/sayhello", method = RequestMethod.POST)
    String sayHello(Person person);
}