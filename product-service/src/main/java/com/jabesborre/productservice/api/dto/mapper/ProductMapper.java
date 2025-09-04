package com.jabesborre.productservice.api.dto.mapper;

import com.jabesborre.productservice.api.dto.ProductDTO;
import com.jabesborre.productservice.domain.Product;

public class ProductMapper {
    public static ProductDTO toDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getStock(), product.getPrice()
        );
    }

    public static Product toEntity(ProductDTO dto) {
        return Product.builder()
                .id(dto.id())
                .name(dto.name())
                .stock(dto.stock())
                .price(dto.price())
                .build();
    }
}
