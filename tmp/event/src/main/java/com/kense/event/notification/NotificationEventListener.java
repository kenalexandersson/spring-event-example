package com.kense.event.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class NotificationEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationEventListener.class);

    @Async
    @EventListener
    public void handleEvent(NotificationEvent event) {

        LOGGER.info("Got event {}", event.getName());

        waitSeconds(3);
    }

    private void waitSeconds(int seconds) {
        try {
            LOGGER.info("Processing...");
            TimeUnit.SECONDS.sleep(seconds);
            LOGGER.info("Processing done!");
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
