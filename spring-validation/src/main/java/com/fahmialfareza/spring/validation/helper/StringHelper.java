package com.fahmialfareza.spring.validation.helper;

import org.springframework.stereotype.Component;

@Component
public class StringHelper {

    public Boolean isPalindrome(String value) {
        String reverse = new StringBuilder(value).reverse().toString();
        return value.equals(reverse);
    }
}
