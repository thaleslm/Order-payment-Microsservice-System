package com.dev.Order_payment_Microsservice_System.controller;

import com.dev.Order_payment_Microsservice_System.dtos.OrderDTO;
import com.dev.Order_payment_Microsservice_System.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    private ResponseEntity<String> enqueOrder(@RequestBody @Valid OrderDTO order){
        this.orderService.enqueueOrder(order);
        return ResponseEntity.ok("Order created successfully");
    }
}
