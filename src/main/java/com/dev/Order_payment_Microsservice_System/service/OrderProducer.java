package com.dev.Order_payment_Microsservice_System.service;

import com.dev.Order_payment_Microsservice_System.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    @Value("${queue.exchange.order}")
    public String QUEUE_EXCHANGE ;
    @Value("${queue.routing.key.order}")
    public String ORDER_KEY_QUEUE ;
    @Autowired
    private  RabbitmqProducer rabbitmqProducer;

    public void SendOrderToQueue(Order order){
        this.rabbitmqProducer.send(QUEUE_EXCHANGE,ORDER_KEY_QUEUE,order);
    }
}
