package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Locality;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {


}