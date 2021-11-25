package com.github.fabrliciolfj.customerservice.controller.dto;

import com.github.fabrliciolfj.customerservice.entities.Customer;
import com.github.fabrliciolfj.customerservice.entities.Status;

public class CustomerDTOMapper {

    private CustomerDTOMapper() { }

    public static Customer toEntity(final CustomerRequestDTO dto) {
        return Customer.builder()
                .status(Status.UNKNOWN)
                .name(dto.getName())
                .document(dto.getDocument())
                .build();
    }
}
