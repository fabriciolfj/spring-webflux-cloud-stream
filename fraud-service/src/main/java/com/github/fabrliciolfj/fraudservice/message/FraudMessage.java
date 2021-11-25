package com.github.fabrliciolfj.fraudservice.message;

import com.github.fabrliciolfj.fraudservice.dto.CustomerDTO;
import com.github.fabrliciolfj.fraudservice.dto.CustomerStatusDTO;
import com.github.fabrliciolfj.fraudservice.dto.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.function.Function;

@Component
@Slf4j
public class FraudMessage {

    private final Random random = new Random();

    @Bean
    public Function<CustomerDTO, CustomerStatusDTO> analyzefraud() {
        return dto -> {
            log.info("Receive: {}", dto);
            if (random.nextInt() % 2 == 0) {
                return CustomerStatusDTO.builder()
                        .code(dto.getCode())
                        .status(Status.VALID.toString())
                        .build();
            }

            return CustomerStatusDTO.builder()
                    .code(dto.getCode())
                    .status(Status.INVALID.toString())
                    .build();
        };
    }
}
