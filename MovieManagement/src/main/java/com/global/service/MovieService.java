package com.global.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.exception.IdNotFoundException;
import com.global.modal.Actor;
import com.global.modal.Movie;
import com.global.repository.ActorRepo;
import com.global.repository.GeneresRepo;
import com.global.repository.MovieRepo;

@Service
public class MovieService {

	@Autowired
	MovieRepo movieRepo;
	
	@Autowired
	ActorRepo actorRepo;
	
	@Autowired
	GeneresRepo generesRepo;
	
    public Movie saveMovie(Movie movie){
      return movieRepo.save(movie);
    }

   
    public List<Movie> findAllMovie(){
        return movieRepo.findAll();
    }

    public Movie findMovie(int movieId){
    	Optional<Movie> fromRepo = movieRepo.findById(movieId);
    	if(fromRepo.isPresent())
    	{
    		Movie movie = fromRepo.get();
    		return movie;
    	}
    	else
    	{
    		throw new IdNotFoundException("movieId not found to fetch movie record");
    	}
        
    }
    
    public Movie findActorByMovieName(String title)
    {
    	 Movie movie = movieRepo.findByTitle(title);
    	 if(movie==null)
    	 {
    		 throw new IdNotFoundException("movie name not found to fetch movie record");
    	 }
    	 return movie;
    }
    
    public Set<Actor> findActorById(int movieId)
    {
    	 //Movie movie = movieRepo.findById(movieId).get();
    	Optional<Movie> fromRepo = movieRepo.findById(movieId);
    	if(fromRepo.isPresent())
    	{
    		Movie movie = fromRepo.get();
    		Set<Actor> actor = movie.getActor();
       	 	return actor;	
    	}
    	else
    	{
    		throw new IdNotFoundException("movieId not found to fetch record in which actor play roll");
    	}
    	
    	 
    }
    
    public Movie updateMovie(Movie movie, int movieId)
    {
    	Movie fromRepo = movieRepo.findById(movieId).get();
    	if(fromRepo!=null)
    	{
    		fromRepo.setTitle(movie.getTitle());
    		fromRepo.setReleasedYear(movie.getReleasedYear());
    		fromRepo.setActor(movie.getActor());
    		movieRepo.save(fromRepo);
    	}
    	else
    	{
    		throw new IdNotFoundException("movieid not found to update record");
    	}
    	
    	return fromRepo;
    	
    }
    
    public void deleteByMovieId(int movieId)
    {
    	if(!movieRepo.existsById(movieId))
    	{
    		throw new IdNotFoundException("movieId not found to delete record");
    	}
    	movieRepo.deleteById(movieId);
    }
}
