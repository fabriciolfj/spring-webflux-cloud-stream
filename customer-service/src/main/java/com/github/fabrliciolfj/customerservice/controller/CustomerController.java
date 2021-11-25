package com.github.fabrliciolfj.customerservice.controller;

import com.github.fabrliciolfj.customerservice.controller.dto.CustomerDTOMapper;
import com.github.fabrliciolfj.customerservice.controller.dto.CustomerRequestDTO;
import com.github.fabrliciolfj.customerservice.entities.Customer;
import com.github.fabrliciolfj.customerservice.usecase.CustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerUseCase useCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<?> created(@RequestBody final CustomerRequestDTO requestDTO) {
        return Mono.just(requestDTO)
                .map(req -> CustomerDTOMapper.toEntity(req))
                .flatMap(entity -> useCase.save(entity));
    }

    @GetMapping("/{code}")
    public Mono<Customer> findCode(@PathVariable("code") final String code) {
        return useCase.findByCode(code);
    }
}
