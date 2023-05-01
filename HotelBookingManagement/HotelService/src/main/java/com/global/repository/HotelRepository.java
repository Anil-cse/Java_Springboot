package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {


}