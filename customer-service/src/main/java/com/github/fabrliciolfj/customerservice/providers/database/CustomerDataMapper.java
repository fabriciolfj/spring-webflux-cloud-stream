package com.github.fabrliciolfj.customerservice.providers.database;

import com.github.fabrliciolfj.customerservice.entities.Customer;
import com.github.fabrliciolfj.customerservice.entities.Status;

public class CustomerDataMapper {

    private CustomerDataMapper() { }

    public static CustomerData toData(final Customer customer) {
        return CustomerData.builder()
                .name(customer.getName())
                .document(customer.getDocument())
                .code(customer.getCode())
                .status(customer.getStatus().getDescribe())
                .build();
    }

    public static Customer toEntity(final CustomerData data) {
        return Customer.builder()
                .name(data.getName())
                .status(Status.toEnum(data.getStatus()))
                .code(data.getCode())
                .build();
    }
}
