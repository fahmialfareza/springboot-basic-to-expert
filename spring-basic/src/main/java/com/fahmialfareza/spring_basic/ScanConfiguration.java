package com.fahmialfareza.spring_basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.fahmialfareza.spring_basic.configuration"
})
public class ScanConfiguration {
}
