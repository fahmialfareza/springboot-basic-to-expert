package com.fahmialfareza.spring_basic;

import com.fahmialfareza.spring_basic.configuration.BarConfiguration;
import com.fahmialfareza.spring_basic.configuration.FooConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        FooConfiguration.class,
        BarConfiguration.class,
})
public class MainConfiguration {
}
