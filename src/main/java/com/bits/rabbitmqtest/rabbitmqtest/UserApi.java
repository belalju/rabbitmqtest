package com.bits.rabbitmqtest.rabbitmqtest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/user")
public class UserApi {
    private final MessageSender messageSender;

    public UserApi(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @PostMapping(value = "/publishUser")
    public void sendUserMessageToRabbitMq() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(RandomStringUtils.randomAlphabetic(5));
        messageSender.send(user);
    }
}
