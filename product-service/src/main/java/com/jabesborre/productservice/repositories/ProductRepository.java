package com.jabesborre.productservice.repositories;

import com.jabesborre.productservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
