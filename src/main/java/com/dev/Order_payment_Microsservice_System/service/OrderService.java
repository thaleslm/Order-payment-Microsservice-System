package com.dev.Order_payment_Microsservice_System.service;

import com.dev.Order_payment_Microsservice_System.domain.order.Order;
import com.dev.Order_payment_Microsservice_System.domain.order.StatusType;
import com.dev.Order_payment_Microsservice_System.dtos.OrderDTO;
import com.dev.Order_payment_Microsservice_System.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderProducerService orderProducerService;

    public void enqueueOrder(OrderDTO order){
        Order newOrder = new Order(order.description(), StatusType.PROCESSING);
        var orderSaved =this.saveOrder(newOrder);

        this.orderProducerService.SendOrderToQueue(orderSaved);
    }

    private Order saveOrder(Order order){
        return this.orderRepository.save(order);
    }

}
