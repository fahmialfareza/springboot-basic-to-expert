package com.fahmialfareza.spring_basic.data.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CyclicC {

    private CyclicA cyclicA;
}
