package com.dev.Order_payment_Microsservice_System.messaging.consumer;

import com.dev.Order_payment_Microsservice_System.domain.order.Order;
import com.dev.Order_payment_Microsservice_System.service.OrderService;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class OrderConsumer {

    @Autowired
    private OrderService orderService;

    @RabbitListener(queues =  "${queue.name.order}")
    public void listen(@Payload Order order){
        try {
            this.orderService.processOrder(order.getId());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
