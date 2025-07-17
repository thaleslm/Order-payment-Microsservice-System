package com.dev.Order_payment_Microsservice_System.dto;

import jakarta.validation.constraints.NotBlank;

public record OrderDTO(
        @NotBlank(message="A descrição é obrigatória") String descripion
){}
