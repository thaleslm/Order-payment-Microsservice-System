package com.dev.Order_payment_Microsservice_System.controller;

import com.dev.Order_payment_Microsservice_System.dto.OrderDTO;
import com.dev.Order_payment_Microsservice_System.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    private void enqueOrder(OrderDTO order){


    }
}
