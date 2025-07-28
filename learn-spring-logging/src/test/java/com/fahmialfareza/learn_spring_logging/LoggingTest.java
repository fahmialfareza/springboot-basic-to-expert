package com.fahmialfareza.learn_spring_logging;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@Slf4j
@SpringBootTest
@TestPropertySource({
        "classpath:application-test.properties"
})
public class LoggingTest {

    @Test
    void testLongLogging() {
        for (int i = 0; i < 1_000; i++) {
            log.warn("Hello World {}", i);
        }
    }

    @Test
    void testLog() {
        log.info("Learn Java");
        log.warn("Learn Spring");
        log.error("Learn Programmer Zaman Now");
    }
}
