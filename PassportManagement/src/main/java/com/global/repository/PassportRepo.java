package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Passport;

@Repository
public interface PassportRepo extends JpaRepository<Passport, Integer> {

}
