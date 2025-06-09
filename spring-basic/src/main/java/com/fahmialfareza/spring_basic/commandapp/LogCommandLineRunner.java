package com.fahmialfareza.spring_basic.commandapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class LogCommandLineRunner implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        log.info("Log Command Line Runner: {}", Arrays.toString(args));
    }
}
