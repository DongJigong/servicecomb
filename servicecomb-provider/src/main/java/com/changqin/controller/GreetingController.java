package com.changqin.controller;

import org.apache.servicecomb.provider.rest.common.RestSchema;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.core.MediaType;

@RestSchema(schemaId = "greeting")
@RequestMapping(path = "/greeting", produces = MediaType.TEXT_PLAIN)
public class GreetingController {

  @RequestMapping(path = "/sayhello/{name}", method = RequestMethod.GET)
  @ResponseBody
  public String sayHello(@PathVariable("name") String name) {
    return "hello " + name;
  }
}