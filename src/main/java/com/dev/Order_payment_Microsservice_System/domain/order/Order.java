package com.dev.Order_payment_Microsservice_System.domain.order;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="Orders")
@Table(name="Orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
