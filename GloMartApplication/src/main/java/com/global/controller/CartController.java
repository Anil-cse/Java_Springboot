package com.global.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.modal.Cart;
import com.global.modal.Product;
import com.global.repo.CartRepository;
import com.global.repo.ProductRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CartController {

	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@PostMapping("add/{id}")
	public Cart addCart(@RequestBody Cart cart, @PathVariable Long id)
	{
		Product product1 = productRepo.findById(id).get();
		List<Product> list = new ArrayList<>();
		list.add(product1);
		cart.setProducts(list);
		return cartRepo.save(cart);
	}
	
}
