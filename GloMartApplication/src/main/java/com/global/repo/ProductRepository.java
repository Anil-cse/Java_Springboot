package com.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
