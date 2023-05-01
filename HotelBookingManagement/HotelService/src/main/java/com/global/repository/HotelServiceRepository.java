package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.HotelService;

@Repository
public interface HotelServiceRepository extends JpaRepository<HotelService, Long> {


}