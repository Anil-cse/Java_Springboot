package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}
