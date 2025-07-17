package com.dev.Order_payment_Microsservice_System.messaging.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqProducer {
    @Autowired
    private  AmqpTemplate amqpTemplate;

    public void send(String exchange, String routingKey, Object playload){
        amqpTemplate.convertAndSend(exchange,routingKey,playload);
        System.out.println("Success send message!"+ exchange + routingKey+ playload);
    }

}
