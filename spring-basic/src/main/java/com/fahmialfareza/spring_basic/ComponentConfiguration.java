package com.fahmialfareza.spring_basic;

import com.fahmialfareza.spring_basic.data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "com.fahmialfareza.spring_basic.service",
        "com.fahmialfareza.spring_basic.repository",
        "com.fahmialfareza.spring_basic.configuration"
})
@Import(MultiFoo.class)
public class ComponentConfiguration {
}
