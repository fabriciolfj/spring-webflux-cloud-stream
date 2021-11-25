package com.github.fabrliciolfj.fraudservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.util.stream.Stream.of;

@Getter
@RequiredArgsConstructor
public enum Status {

    VALID("valid"), INVALID("invalid"), UNKNOWN("unknown");

    private final String describe;

    public static Status toEnum(final String describe) {
        return of(Status.values())
                .filter(p -> p.describe.equalsIgnoreCase(describe))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Status not found: " + describe));
    }

}
