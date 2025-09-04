package com.jabesborre.productservice.api.dto;

import java.time.Instant;

public record ApiError(
        String code,
        String message,
        Instant timestamp
) {
}
