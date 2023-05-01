package com.global.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.exception.IdNotFoundException;
import com.global.modal.Account;
import com.global.modal.Customer;
import com.global.repository.AccountRepo;
import com.global.repository.CustomerRepo;

@Service
public class CustomerService {

	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	AccountRepo accountRepo;
	
	public Customer addCustomer(Customer customer)
	{
		return customerRepo.save(customer);
	}
	
	public List<Customer> findAllCustomer()
	{
		return customerRepo.findAll();
	}
	
	public Customer findCustomerById(int cId)
	{
		Optional<Customer> find = customerRepo.findById(cId);
		if(find.isPresent())
		{
			Customer customer = find.get();
			return customer;
		}
		else
		{
			throw new IdNotFoundException("customer id does not exist");
		}
		
	}
	
	public Customer updateCustomer(Customer customer, int cId)
	{
		Optional<Customer> find = customerRepo.findById(cId);
		Customer save=null;
		if(find.isPresent())
		{
			Customer fromRepo = find.get();
			fromRepo.setCId(customer.getCId());
			fromRepo.setName(customer.getName());
			fromRepo.setAddress(customer.getAddress());
			fromRepo.setAccount(customer.getAccount());
			save = customerRepo.save(fromRepo);
		}
		else
		{
			throw new IdNotFoundException("Customer id not found for updateion");
		}
		return save;
	}
	
	
	public void deleteCustomer(int cId)
	{
		if(!customerRepo.existsById(cId))
    	{
    		throw new IdNotFoundException("Customer id not found to delete record");
    	}
    	customerRepo.deleteById(cId);
	}
	
	public List<Account> findAll()
	{
		return accountRepo.findAll();
	}
}
