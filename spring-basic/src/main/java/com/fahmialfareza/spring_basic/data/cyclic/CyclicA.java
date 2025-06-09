package com.fahmialfareza.spring_basic.data.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CyclicA {

    private CyclicB cyclicB;
}
