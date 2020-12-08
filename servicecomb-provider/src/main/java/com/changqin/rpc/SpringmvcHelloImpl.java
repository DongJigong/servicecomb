package com.changqin.rpc;

import com.changqin.model.Person;
import org.springframework.web.bind.annotation.RequestParam;


public class SpringmvcHelloImpl implements Hello {

    public String sayHi(@RequestParam(name = "name") String name) {
        return "Hello " + name;
    }


    public String sayHello(Person person) {
        return "Hello person " + person.getName();
    }
}