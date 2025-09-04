package com.jabesborre.productservice.api.controller;

import com.jabesborre.productservice.api.dto.ProductDTO;
import com.jabesborre.productservice.services.ProductService;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@Validated
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok(productService.get(id));
    }

    @PatchMapping("/{id}/reserve")
    public ResponseEntity<ProductDTO> reserve(@PathVariable Long id, @RequestParam @Min(1) Integer units) {
        return ResponseEntity.ok(productService.reserve(id, units));
    }
}
