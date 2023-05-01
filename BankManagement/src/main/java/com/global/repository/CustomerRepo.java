package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
