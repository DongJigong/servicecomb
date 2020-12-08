package com.changqin.rpc;

import io.swagger.annotations.SwaggerDefinition;
import org.apache.servicecomb.provider.pojo.RpcSchema;
import org.apache.servicecomb.tracing.Span;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


public interface BusinessService {

    String say(String name);
}
