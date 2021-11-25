package com.github.fabrliciolfj.customerservice.providers.message;

import com.github.fabrliciolfj.customerservice.entities.Customer;
import com.github.fabrliciolfj.customerservice.providers.message.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CustomerMessage {

    private final StreamBridge streamBridge;

    public Mono<Customer> send(final Customer customer) {
        return Mono.just(customer)
                .flatMap(c -> {
                    final var dto = CustomerDTO.builder()
                            .document(c.getDocument())
                            .code(c.getCode())
                            .build();
                    streamBridge.send("fraud-topic", dto);
                    return Mono.just(c);
                }).log();
    }
}
