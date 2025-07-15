package com.dev.Order_payment_Microsservice_System.repositories;

import com.dev.Order_payment_Microsservice_System.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
