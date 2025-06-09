package com.fahmialfareza.spring_basic;

import com.fahmialfareza.spring_basic.data.Bar;
import com.fahmialfareza.spring_basic.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    public void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfiguration.class);
    }

    @Test
    void testImport() {

        Foo foo = applicationContext.getBean(Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);

    }
}
