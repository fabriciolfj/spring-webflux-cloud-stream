package com.github.fabrliciolfj.customerservice.providers.database;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveCrudRepository<CustomerData, Long> {

    @Query("select * from customer where code = :code")
    Mono<CustomerData> findByCode(final String code);
}
