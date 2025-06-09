package com.fahmialfareza.spring_basic.listener;

import com.fahmialfareza.spring_basic.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserListener {

    @EventListener(classes = LoginSuccessEvent.class)
    public void onLoginSuccessListener(LoginSuccessEvent event) {
        log.info("User {} has successfully logged in", event.getUser());
    }

    @EventListener(classes = LoginSuccessEvent.class)
    public void onLoginSuccessListener2(LoginSuccessEvent event) {
        log.info("User {} has successfully logged in", event.getUser());
    }

    @EventListener(classes = LoginSuccessEvent.class)
    public void onLoginSuccessListener3(LoginSuccessEvent event) {
        log.info("User {} has successfully logged in", event.getUser());
    }
}
