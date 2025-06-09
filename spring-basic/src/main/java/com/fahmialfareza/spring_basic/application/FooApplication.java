package com.fahmialfareza.spring_basic.application;

import com.fahmialfareza.spring_basic.data.Bar;
import com.fahmialfareza.spring_basic.data.Foo;
import com.fahmialfareza.spring_basic.listener.AppStartingListener;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FooApplication {

    @Bean
    public Foo foo() {
        return new Foo();
    }

//    public static void main(String[] args) {
//        ApplicationContext applicationContext = SpringApplication.run(FooApplication.class, args);
//
//        Foo foo = applicationContext.getBean(Foo.class);
//        System.out.println(foo);
//    }

//    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(FooApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.setListeners(List.of(new AppStartingListener()));
//
//        ConfigurableApplicationContext applicationContext = application.run(args);
//
//        Foo foo = applicationContext.getBean(Foo.class);
//        System.out.println(foo);
//    }
}
