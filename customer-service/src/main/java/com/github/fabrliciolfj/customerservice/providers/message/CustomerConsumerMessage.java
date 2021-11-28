package com.github.fabrliciolfj.customerservice.providers.message;

import com.github.fabrliciolfj.customerservice.entities.Status;
import com.github.fabrliciolfj.customerservice.providers.CustomerDatabaseProvider;
import com.github.fabrliciolfj.customerservice.providers.message.dto.CustomerStatusDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Schedulers;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerConsumerMessage {

    private final CustomerDatabaseProvider provider;

    @Bean
    public Consumer<CustomerStatusDTO> customerfraud() {
        return customerStatusDTO -> {
            log.info("Receive  fraud: {}", customerStatusDTO.toString());
            provider.updateStatus(Status.toEnum(customerStatusDTO.getStatus()), customerStatusDTO.getCode())
                    .doOnSuccess(c -> log.info("Consumer sucess: {}", c.toString()))
                    .doOnError(e ->  log.error("Fail consumer: {}", e.getMessage()))
                    .subscribeOn(Schedulers.immediate())
                    .subscribe();
        };
    }
}
