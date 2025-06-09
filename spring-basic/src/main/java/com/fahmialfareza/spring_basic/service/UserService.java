package com.fahmialfareza.spring_basic.service;

import com.fahmialfareza.spring_basic.data.User;
import com.fahmialfareza.spring_basic.event.LoginSuccessEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public boolean login(String username, String password) {
        if (isLoginSuccess(username, password)) {
            applicationEventPublisher.publishEvent(new LoginSuccessEvent(new User(username)));
            return true;
        }

        return false;
    }

    public boolean isLoginSuccess(String username, String password) {
        return "fahmi".equals(username) && "alfareza".equals(password);
    }
}
