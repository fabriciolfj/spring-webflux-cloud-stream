package com.github.fabrliciolfj.customerservice.usecase;

import com.github.fabrliciolfj.customerservice.entities.Customer;
import com.github.fabrliciolfj.customerservice.exceptions.CustomerSaveException;
import com.github.fabrliciolfj.customerservice.providers.CustomerDatabaseProvider;
import com.github.fabrliciolfj.customerservice.providers.message.CustomerMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class CustomerUseCase {

    private final CustomerDatabaseProvider provider;
    private final CustomerMessage customerMessage;

    public Mono<?> save(final Customer customer) {
        return Mono.just(customer)
                .map(c -> c.generatedCode())
                .log()
                .flatMap(provider::save)
                .flatMap(customerMessage::send)
                .onErrorResume(e -> Mono.error(new CustomerSaveException(e.getMessage())));
    }

    public Mono<Customer> findByCode(final String code) {
        return provider.findCode(code);
    }
}
