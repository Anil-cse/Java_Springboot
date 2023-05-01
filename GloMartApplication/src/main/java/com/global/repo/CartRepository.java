package com.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
