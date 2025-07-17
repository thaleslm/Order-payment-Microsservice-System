package com.dev.Order_payment_Microsservice_System.domain.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name="Orders")
@Table(name="Orders")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    public Order(String description, StatusType status) {
        this.description = description;
        this.status = status;
    }
}
