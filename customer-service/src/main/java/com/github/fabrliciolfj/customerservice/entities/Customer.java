package com.github.fabrliciolfj.customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String name;
    private String code;
    private String document;
    private Status status;

    public Customer generatedCode() {
        this.code = UUID.randomUUID().toString();
        return this;
    }
}
