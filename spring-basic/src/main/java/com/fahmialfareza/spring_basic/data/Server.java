package com.fahmialfareza.spring_basic.data;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server {

    @PostConstruct
    public void start() {
        log.info("Server is starting...");
    }

    @PreDestroy
    public void stop() {
        log.info("Server is stopping...");
    }
}
