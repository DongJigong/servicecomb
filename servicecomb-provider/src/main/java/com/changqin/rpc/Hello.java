package com.changqin.rpc;

import com.changqin.model.Person;

public interface Hello {
    String sayHi(String name);
    String sayHello(Person person);
}