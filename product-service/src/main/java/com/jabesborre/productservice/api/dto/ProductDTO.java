package com.jabesborre.productservice.api.dto;

public record ProductDTO(
        Long id, String name, Integer stock, Double price
) {
}
