package com.global.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.exception.IdNotFoundException;
import com.global.modal.Actor;
import com.global.modal.Generes;
import com.global.modal.Movie;
import com.global.repository.ActorRepo;
import com.global.repository.GeneresRepo;
import com.global.repository.MovieRepo;

@Service
public class GenereService {
	
	@Autowired
	GeneresRepo generesRepo;
	
	@Autowired
	MovieRepo movieRepo;
	
	@Autowired
	ActorRepo actorRepo;
	
    public Generes addGenere(Generes generes){
      return generesRepo.save(generes);
    }
	
	
    public List<Generes> findGenere() {
      return generesRepo.findAll();
    }
    
    public Generes findGenereById(int genId)
    {
    	Optional<Generes> fromRepo = generesRepo.findById(genId);
    	if(fromRepo.isPresent())
    	{
    		return fromRepo.get();
    	}
    	else
    	{
    		throw new IdNotFoundException("id not found for generes");
    	}
    }
    
    public List<Movie> findMovieById(int genId)
    {
    	Optional<Generes> fromRepo = generesRepo.findById(genId);
    	if(fromRepo.isPresent())
    	{
    		Generes generes = fromRepo.get();
    		List<Movie> movie = generes.getMovie();
       	 	return movie;
    	}
    	else
    	{
    		throw new IdNotFoundException("id not found for generes to fetch movie record");
    	}
    	
    	
    }
    public List<Movie> findMovieByName(String name)
    {
    	Generes findByName = generesRepo.findByName(name);
    	if(findByName==null)
    	{
    		throw new IdNotFoundException("name not found for generes to fetch movie record");
    	}
    	else
    	{
    	List<Movie> movie = findByName.getMovie();
    	return movie;
    	}
    }
    
    public void deleteGenere(int genId)
    {
    	//generesRepo.deleteById(genId);
    	if(!generesRepo.existsById(genId))
    	{
    		throw new IdNotFoundException("Id not found for generes to delete data");
    	}
    	generesRepo.deleteById(genId);
    }

}
