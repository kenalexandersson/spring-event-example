package com.kense.event.web;

import com.kense.event.notification.NotificationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    private ApplicationEventPublisher publisher;

    @Autowired
    public EventController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping(path = "/api/trigger")
    public String triggerEvent(@RequestParam String name) {

        LOGGER.info("Publishing notification event for {}", name);

        publisher.publishEvent(new NotificationEvent(name));

        LOGGER.info("Publishing notification event for {} done", name);

        return "Event triggered";
    }
}
