package com.jabesborre.productservice.services;

import com.jabesborre.productservice.api.dto.ProductDTO;
import com.jabesborre.productservice.domain.Product;

public interface ProductService {
    ProductDTO get(Long id);
    ProductDTO reserve(Long id, int units);

}
