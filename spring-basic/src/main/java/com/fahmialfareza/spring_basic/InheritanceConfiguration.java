package com.fahmialfareza.spring_basic;

import com.fahmialfareza.spring_basic.service.MerchantServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        MerchantServiceImpl.class
})
public class InheritanceConfiguration {
}
