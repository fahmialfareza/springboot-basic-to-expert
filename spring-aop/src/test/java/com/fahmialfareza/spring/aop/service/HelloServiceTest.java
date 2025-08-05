package com.fahmialfareza.spring.aop.service;

import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    void helloService() {
        Assertions.assertEquals("Hello, Reza", helloService.hello("Reza"));
        Assertions.assertEquals("Hello, Fahmi Alfareza", helloService.hello("Fahmi", "Alfareza"));
        Assertions.assertEquals("Bye, Reza", helloService.bye("Reza"));

        helloService.test();
    }
}
