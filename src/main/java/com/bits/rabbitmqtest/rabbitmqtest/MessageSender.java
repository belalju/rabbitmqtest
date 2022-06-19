package com.bits.rabbitmqtest.rabbitmqtest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    private final RabbitTemplate rabbitTemplate;

    public MessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void send(User user){
        try{
            rabbitTemplate.convertAndSend(exchange, routingkey, user);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
