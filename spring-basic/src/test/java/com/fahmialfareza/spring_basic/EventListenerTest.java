package com.fahmialfareza.spring_basic;

import com.fahmialfareza.spring_basic.listener.LoginAgainSuccessListener;
import com.fahmialfareza.spring_basic.listener.LoginSuccessListener;
import com.fahmialfareza.spring_basic.listener.UserListener;
import com.fahmialfareza.spring_basic.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class EventListenerTest {

    @Configuration
    @Import({
            UserService.class,
            LoginSuccessListener.class,
            LoginAgainSuccessListener.class,
            UserListener.class,
    })
    public static class TestConfiguration {

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testEvent() {
        UserService userService = applicationContext.getBean(UserService.class);

        userService.login("fahmi", "alfareza");
        userService.login("alfareza", "fahmi");
        userService.login("alfa", "reza");
    }
}
