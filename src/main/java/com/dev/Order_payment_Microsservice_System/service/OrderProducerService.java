package com.dev.Order_payment_Microsservice_System.service;

import com.dev.Order_payment_Microsservice_System.domain.order.Order;
import com.dev.Order_payment_Microsservice_System.messaging.producer.RabbitmqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderProducerService {

    @Value("${queue.exchange.order}")
    private String QUEUE_EXCHANGE ;
    @Value("${queue.routing.key.order}")
    private String ORDER_KEY_QUEUE ;
    @Autowired
    private RabbitmqProducer rabbitmqProducer;

    public void SendOrderToQueue(Order order){
        try {
            this.rabbitmqProducer.send(QUEUE_EXCHANGE,ORDER_KEY_QUEUE,order);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
