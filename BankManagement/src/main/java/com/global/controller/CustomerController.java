package com.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.modal.Account;
import com.global.modal.Customer;
import com.global.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.OK);
	}
	
	@GetMapping("/findAllCustomer")
	public ResponseEntity<List<Customer>> findAllCustomer()
	{
		return new ResponseEntity<List<Customer>>(customerService.findAllCustomer(),HttpStatus.OK);
	}
	
	@GetMapping("/findCustomer/{cId}")
	public ResponseEntity<Customer> findByCustomer(@PathVariable int cId)
	{
		return new ResponseEntity<Customer>(customerService.findCustomerById(cId), HttpStatus.OK);
	}
	
	@PostMapping("/updateCustomer/{cId}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable int cId)
	{
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, cId), HttpStatus.OK);
	}
	
	
	@GetMapping("/findAllAccount")
	public ResponseEntity<List<Account>> findAll()
	{
		return new ResponseEntity<List<Account>>(customerService.findAll(),HttpStatus.OK);
	
	}
	
	@DeleteMapping("/deleteCustomer/{cId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int cId)
	{
		customerService.deleteCustomer(cId);
		return new ResponseEntity<String>("delete record successfully", HttpStatus.OK);
	}
}
