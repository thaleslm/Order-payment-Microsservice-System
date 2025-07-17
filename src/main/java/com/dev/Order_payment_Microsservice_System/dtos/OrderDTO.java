package com.dev.Order_payment_Microsservice_System.dtos;

import jakarta.validation.constraints.NotBlank;

public record OrderDTO(
        @NotBlank(message="A descrição é obrigatória") String description
){}
