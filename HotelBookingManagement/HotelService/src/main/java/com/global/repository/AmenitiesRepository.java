package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Amenities;

@Repository
public interface AmenitiesRepository extends JpaRepository<Amenities, Long> {

    

}
