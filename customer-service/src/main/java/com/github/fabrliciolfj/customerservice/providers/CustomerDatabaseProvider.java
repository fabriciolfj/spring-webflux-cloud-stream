package com.github.fabrliciolfj.customerservice.providers;

import com.github.fabrliciolfj.customerservice.entities.Customer;
import com.github.fabrliciolfj.customerservice.exceptions.CustomerNotFoundException;
import com.github.fabrliciolfj.customerservice.exceptions.CustomerSaveException;
import com.github.fabrliciolfj.customerservice.providers.database.CustomerDataMapper;
import com.github.fabrliciolfj.customerservice.providers.database.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CustomerDatabaseProvider {

    private final CustomerRepository repository;

    public Mono<Customer> save(final Customer customer) {
        return Mono.just(CustomerDataMapper.toData(customer))
                .flatMap(repository::save)
                .flatMap(v -> Mono.just(customer));
    }

    public Mono<Customer> findCode(final String code) {
        return repository.findByCode(code)
                .switchIfEmpty(Mono.defer(() -> Mono.error(new CustomerNotFoundException("Customer not found: " + code))))
                .map(data -> CustomerDataMapper.toEntity(data));
    }
}
