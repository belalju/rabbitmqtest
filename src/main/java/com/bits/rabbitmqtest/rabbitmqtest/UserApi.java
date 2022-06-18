package com.bits.rabbitmqtest.rabbitmqtest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserApi {
    private final MessageSender messageSender;

    public UserApi(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToRabbitMq() {
        messageSender.send(RandomStringUtils.randomAlphabetic(5));
    }
}
