package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.RoomInfo;

@Repository
public interface RoomInfoRepository extends JpaRepository<RoomInfo, Long> {

	
}