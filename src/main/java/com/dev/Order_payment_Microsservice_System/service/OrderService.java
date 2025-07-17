package com.dev.Order_payment_Microsservice_System.service;

import com.dev.Order_payment_Microsservice_System.domain.order.Order;
import com.dev.Order_payment_Microsservice_System.domain.order.StatusType;
import com.dev.Order_payment_Microsservice_System.dto.OrderDTO;
import com.dev.Order_payment_Microsservice_System.repositories.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderProducerService orderProducerService;

    private void enqueueOrder(@RequestBody @Valid OrderDTO order){
        Order newOrder = new Order(order.descripion(), StatusType.PROCESSING);
        this.orderProducerService.SendOrderToQueue(newOrder);
        this.saveOrder(newOrder);
    }

    private void saveOrder(Order order){
        this.orderRepository.save(order);
    }

}
