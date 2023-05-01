package com.global.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.modal.Cart;
import com.global.modal.Product;
import com.global.repo.ProductRepository;


@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;
	
	@PostMapping("create")
	public Product createProduct(@RequestBody Product product)
	{
		return productRepo.save(product);
	}

	@GetMapping("productById/{id}")
	public Product getProductById(@PathVariable Long id)
	{
		return productRepo.findById(id).get();
	}
	
	@GetMapping("allProduct")
	public List<Product> getAllProduct()
	{
		return productRepo.findAll();
	}
	
	@PutMapping("updateProduct/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable Long id)
	{
		Product find = productRepo.findById(id).get();
		find.setName(product.getName());
		find.setPrice(product.getPrice());
		find.setDescription(product.getDescription());
		find.setCategory(product.getCategory());
		return productRepo.save(find);
	}
	
	@DeleteMapping("deleteProduct/{id}")
	public String deleteProduct(@PathVariable Long id)
	{
		productRepo.deleteById(id);
		return "product deleted successfully";
	}
	
}
