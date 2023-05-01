package com.global.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer>{

   public Movie findByTitle(String title);
	
}
