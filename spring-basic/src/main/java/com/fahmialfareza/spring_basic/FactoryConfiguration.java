package com.fahmialfareza.spring_basic;

import com.fahmialfareza.spring_basic.factory.PaymentGatewayClientFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    PaymentGatewayClientFactory.class
})
public class FactoryConfiguration {
}
