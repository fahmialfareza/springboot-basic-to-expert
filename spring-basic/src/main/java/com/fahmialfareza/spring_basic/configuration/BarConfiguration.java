package com.fahmialfareza.spring_basic.configuration;

import com.fahmialfareza.spring_basic.data.Bar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BarConfiguration {

    @Bean
    public Bar bar() {
        return new Bar();
    }
}
