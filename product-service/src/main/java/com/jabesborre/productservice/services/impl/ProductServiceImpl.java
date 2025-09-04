package com.jabesborre.productservice.services.impl;

import com.jabesborre.productservice.api.dto.ProductDTO;
import com.jabesborre.productservice.api.dto.mapper.ProductMapper;
import com.jabesborre.productservice.api.error.InsufficientStockException;
import com.jabesborre.productservice.domain.Product;
import com.jabesborre.productservice.api.error.ProductNotFoundException;
import com.jabesborre.productservice.repositories.ProductRepository;
import com.jabesborre.productservice.services.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO get(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("el producto con id: "+id+" no existe"));
        return ProductMapper.toDTO(product);
    }

    @Override
    @Transactional
    public ProductDTO reserve(Long id, int units) {
        ProductDTO productDto = get(id);
        Product product = ProductMapper.toEntity(productDto);

        if(product.getStock() < units)
            throw new InsufficientStockException("No hay suficiente stock para realizar la compra");

        product.setStock(product.getStock() - units);

        return ProductMapper.toDTO(productRepository.save(product));
    }
}
