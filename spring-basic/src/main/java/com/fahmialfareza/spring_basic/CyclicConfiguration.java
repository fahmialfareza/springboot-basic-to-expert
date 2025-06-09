package com.fahmialfareza.spring_basic;

import com.fahmialfareza.spring_basic.data.cyclic.CyclicA;
import com.fahmialfareza.spring_basic.data.cyclic.CyclicB;
import com.fahmialfareza.spring_basic.data.cyclic.CyclicC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CyclicConfiguration {

    @Bean
    public CyclicA cyclicA(CyclicB cyclicB) {
        return new CyclicA(cyclicB);
    }

    public CyclicB cyclicB(CyclicC cyclicC) {
        return new CyclicB(cyclicC);
    }

    public CyclicC cyclicC(CyclicA cyclicA) {
        return new CyclicC(cyclicA);
    }
}
