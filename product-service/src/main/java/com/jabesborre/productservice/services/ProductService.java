package com.jabesborre.productservice.services;

import com.jabesborre.productservice.api.dto.ProductDTO;

public interface ProductService {
    ProductDTO get(Long id);
    ProductDTO reserve(Long id, int units);

}
